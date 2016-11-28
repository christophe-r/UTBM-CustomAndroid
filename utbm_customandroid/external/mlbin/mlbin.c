#include <stdio.h>
#include <stdlib.h>

#include <libusb.h>

#define ML_VENDOR_ID			0x0416
#define ML_DEVICE_ID			0x9391

#define ML_ACTION_FIRE			0x10
#define ML_ACTION_MOVE_DOWN		0x1
#define ML_ACTION_MOVE_LEFT		0x8
#define ML_ACTION_MOVE_RIGHT		0x4
#define ML_ACTION_MOVE_UP		0x2
#define ML_ACTION_STOP			0x0

static struct libusb_device_handle **devh;
int nbr_device;

int mlbin_init_usb(void)
{
	libusb_device **list;
	libusb_device **devices = NULL;
	int count, ret, i;

	printf("Calling mlbin_init\n");

	ret = libusb_init(NULL);

	if(ret < 0) {
		printf("Couldn't initialize libusb.\n");
		goto error;
	}

	count = libusb_get_device_list(NULL, &list);
	if (count < 0) {
		printf("Couldn't get device list\n");
		goto list_error;
	}

	nbr_device = 0;
	for (i = 0; i < count; i++) {
		libusb_device *device_test = NULL;
		struct libusb_device_descriptor desc;
		device_test = list[i];
		libusb_get_device_descriptor(device_test, &desc);
		printf("Found a new device : %x:%x\n",
			desc.idVendor, desc.idProduct);
		if (desc.idVendor == ML_VENDOR_ID &&
			desc.idProduct == ML_DEVICE_ID) {
			if (nbr_device == 0)
				devices = malloc(sizeof(void *) * 1);
			else
				devices = realloc(devices, (nbr_device + 1) * sizeof(void *));
			devices[nbr_device++] = device_test;
		}
		if (nbr_device == 0)
			devices = NULL;
	}

	if (!devices) {
		printf("Couldn't find the device\n");
		goto not_found_error;
	}

	devh = malloc(nbr_device * sizeof(void *));
	for (i = 0; i < nbr_device; i++) {
		ret = libusb_open(devices[i], &devh[i]);
		if (ret) {
			printf("Couldn't open device: %d\n", ret);
			goto open_dev_error;
		}
	}

	for (i = 0; i < nbr_device; i++) {
		libusb_detach_kernel_driver(devh[i], 0);
		ret = libusb_claim_interface(devh[i], 0);
		if(ret < 0) {
			printf("Couldn't claim the interface : %d.\n", ret);
			goto if_error;
		}
	}

	libusb_free_device_list(list, count);

	printf("Interface setup.\n");
	return 0;

if_error:
	for (i = 0; i < nbr_device; i++)
		libusb_close(devh[i]);
detach_error:
open_dev_error:
	free(devices);
	free(devh);
not_found_error:
	libusb_free_device_list(list, count);
list_error:
	libusb_exit(NULL);
error:
	exit(1);
}

int mlbin_free_usb(void)
{
	int i;
	for (i = 0; i < nbr_device; i++) {
		libusb_release_interface(devh[i], 0);
		libusb_close(devh[i]);
	}
	libusb_exit(NULL);
	printf("mlbin exiting\n");
	return 0;
}

int mlbin_fire(int device)
{
	if (device == -1) {
		int i;
		for (i = 0; i < nbr_device; i++) {
			unsigned char data[] = {0x5f, ML_ACTION_FIRE, 0xe0, 0xff, 0xfe};
			libusb_control_transfer(devh[i], 0x21, 0x09, 0, 0, data, 5, 300);
		}
	} else {
		unsigned char data[] = {0x5f, ML_ACTION_FIRE, 0xe0, 0xff, 0xfe};
		libusb_control_transfer(devh[device], 0x21, 0x09, 0, 0, data, 5, 300);
	}

	printf("Fire!\n");
	return 0;
}

int mlbin_move_down(int device)
{
	if (device == -1) {
		int i;
		for (i = 0; i < nbr_device; i++) {
			unsigned char data[] = {0x5f, ML_ACTION_MOVE_DOWN, 0xe0, 0xff, 0xfe};
			libusb_control_transfer(devh[i], 0x21, 0x09, 0, 0, data, 5, 300);
		}
	} else {
		unsigned char data[] = {0x5f, ML_ACTION_MOVE_DOWN, 0xe0, 0xff, 0xfe};
		libusb_control_transfer(devh[device], 0x21, 0x09, 0, 0, data, 5, 300);
	}

	printf("Move Down!\n");
	return 0;
}

int mlbin_move_left(int device)
{
	if (device == -1) {
		int i;
		for (i = 0; i < nbr_device; i++) {
			unsigned char data[] = {0x5f, ML_ACTION_MOVE_LEFT, 0xe0, 0xff, 0xfe};
			libusb_control_transfer(devh[i], 0x21, 0x09, 0, 0, data, 5, 300);
		}
	} else {
		unsigned char data[] = {0x5f, ML_ACTION_MOVE_LEFT, 0xe0, 0xff, 0xfe};
		libusb_control_transfer(devh[device], 0x21, 0x09, 0, 0, data, 5, 300);
	}

	printf("Move Left!\n");
	return 0;
}

int mlbin_move_right(int device)
{
	if (device == -1) {
		int i;
		for (i = 0; i < nbr_device; i++) {
			unsigned char data[] = {0x5f, ML_ACTION_MOVE_RIGHT, 0xe0, 0xff, 0xfe};
			libusb_control_transfer(devh[i], 0x21, 0x09, 0, 0, data, 5, 300);
		}
	} else {
		unsigned char data[] = {0x5f, ML_ACTION_MOVE_RIGHT, 0xe0, 0xff, 0xfe};
		libusb_control_transfer(devh[device], 0x21, 0x09, 0, 0, data, 5, 300);
	}

	printf("Move Right!\n");
	return 0;
}

int mlbin_move_up(int device)
{
	if (device == -1) {
		int i;
		for (i = 0; i < nbr_device; i++) {
			unsigned char data[] = {0x5f, ML_ACTION_MOVE_UP, 0xe0, 0xff, 0xfe};
			libusb_control_transfer(devh[i], 0x21, 0x09, 0, 0, data, 5, 300);
		}
	} else {
		unsigned char data[] = {0x5f, ML_ACTION_MOVE_UP, 0xe0, 0xff, 0xfe};
		libusb_control_transfer(devh[device], 0x21, 0x09, 0, 0, data, 5, 300);
	}

	printf("Move Up!\n");
	return 0;
}

int mlbin_stop(void)
{
	unsigned char data[] = {0x5f, ML_ACTION_STOP, 0xe0, 0xff, 0xfe};
	int i;
	for (i = 0; i < nbr_device; i++)
		libusb_control_transfer(devh[i], 0x21, 0x09, 0, 0, data, 5, 300);

	printf("Stop!\n");
	return 0;
}

int mlbin_count_devices(void)
{
	return nbr_device;
}

int main(void)
{
	int ret;
	char dir;
	int time;
	int device;

	mlbin_init_usb();
	mlbin_stop();

	do {
		printf("%d lance missiles ont Ã©tÃ© connectÃ©s au systÃ¨me\n", nbr_device);
		ret = scanf("%d %c %d", &device, &dir, &time);
		if (ret != 3)
			continue;

		printf("%d: %c for %d\n", device, dir, time);
		switch(dir) {
			case 'L':
				mlbin_move_left(device);
				break;
			case 'R':
				mlbin_move_right(device);
				break;
			case 'U':
				mlbin_move_up(device);
				break;
			case 'D':
				mlbin_move_down(device);
				break;
			case 'F':
				mlbin_fire(device);
				break;
			default:
				break;
		}
		sleep(time);
		mlbin_stop();
	} while(ret != EOF);

	mlbin_free_usb();

	return 0;
}

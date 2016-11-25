#ifndef _MLBIN_H_
#define _MLBIN_H_

#define ML_VENDOR_ID			0x0416
#define ML_DEVICE_ID			0x9391

#define ML_ACTION_FIRE			0x10
#define ML_ACTION_MOVE_DOWN		0x1
#define ML_ACTION_MOVE_LEFT		0x8
#define ML_ACTION_MOVE_RIGHT		0x4
#define ML_ACTION_MOVE_UP		0x2
#define ML_ACTION_STOP			0x0

int mlbin_init_usb(void);
int mlbin_free_usb(void);
int mlbin_fire(int device);
int mlbin_move_down(int device);
int mlbin_move_left(int device);
int mlbin_move_right(int device);
int mlbin_move_up(int device);
int mlbin_stop(void);
int mlbin_count_devices(void);
int main(void);

#endif

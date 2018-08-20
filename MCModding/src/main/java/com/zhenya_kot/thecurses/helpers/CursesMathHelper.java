package com.zhenya_kot.thecurses.helpers;

import net.minecraft.util.math.Vec3i;

public class CursesMathHelper {
	public static Vec3i yawPitchToVector (int yaw, int pitch) {
		double xzLen = Math.cos(pitch);
		double x = xzLen * Math.cos(yaw);
		double	y = Math.sin(pitch);
		double	z = xzLen * Math.sin(-yaw);
		return new Vec3i(x, y, z);
	}

	public static Vec3i yawPitchToVector(float yaw, float pitch) {
		return yawPitchToVector((int)yaw, (int)pitch);
	}
	
	public static float yawInvert (float yaw) {
		if (yaw != 0 && yaw != 180) {
			return -yaw;
		} else return yaw == 0 ? 180 : 0;
	}
}

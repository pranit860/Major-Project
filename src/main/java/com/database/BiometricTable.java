package com.database;


public class BiometricTable {
	private long id_aadhar;
	byte[] thumb_print, index_finger_right, ring_finger_right;
	
	
	public long getId_aadhar() {
		return id_aadhar;
	}
	public void setId_aadhar(long id_aadhar) {
		this.id_aadhar = id_aadhar;
	}
	public byte[] getThumb_print() {
		return thumb_print;
	}
	public void setThumb_print(byte[] thumb_print) {
		this.thumb_print = thumb_print;
	}
	public byte[] getIndex_finger_right() {
		return index_finger_right;
	}
	public void setIndex_finger_right(byte[] index_finger_right) {
		this.index_finger_right = index_finger_right;
	}
	public byte[] getRing_finger_right() {
		return ring_finger_right;
	}
	public void setRing_finger_right(byte[] ring_finger_right) {
		this.ring_finger_right = ring_finger_right;
	}


	

}

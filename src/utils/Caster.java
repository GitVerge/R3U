package utils;

import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;

/**
 * @author rob3ns
 */
public class Caster {

	public Caster() { }

	// BitSet to...
	public static byte[] bitSetToByteArray(BitSet bits) {
		byte[] bytes = new byte[bits.length()/8+1];
		for (int i=0; i<bits.length(); i++) {
			if (bits.get(i)) {
				bytes[bytes.length-i/8-1] |= 1<<(i%8);
			}
		}
		return bytes;
	}

	public static String bitSetToString(BitSet bits) {
		byte[] bytes = Caster.bitSetToByteArray(bits);
		return Caster.byteArrayToString(bytes);
	}

	// Byte array to...
	public static BitSet byteArrayToBitSet(byte[] bytes) {
		BitSet bits = new BitSet();
		for (int i = 0; i < bytes.length * 8; i++) {
			if ((bytes[bytes.length - i / 8 - 1] & (1 << (i % 8))) > 0) {
				bits.set(i);
			}
		}
		return bits;
	}

	public static String byteArrayToString(byte[] b) {
		return new String(b);
	}

	// String to...
	public static byte[] stringToByteArray(String s) {
		return s.getBytes();
	}

	public static BitSet stringToBitSet(String s) {
		byte[] bArray = Caster.stringToByteArray(s);
		return Caster.byteArrayToBitSet(bArray);
	}

	// Collections
	public static <T> Iterable<T> safeIterable(Iterable<T> it) {
		return it == null ? Collections.<T>emptyList() : it;
	}
	
	public static <T> boolean isValidCollection(Collection<T> c) {
		return c != null && !c.isEmpty();
	}
	
	public static <T> boolean isValidCollection(Collection<T> c, int index) {
		return isValidCollection(c) && c.size() > index;
	}
}

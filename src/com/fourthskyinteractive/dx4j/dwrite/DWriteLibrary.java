package com.fourthskyinteractive.dx4j.dwrite;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.BridJ;
import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;
import org.bridj.ValuedEnum;
import org.bridj.ann.Library;

@Library("dwrite")
public class DWriteLibrary {
	static {
		BridJ.register();
	}
	
	public enum DWRITE_MEASURING_MODE implements IntValuedEnum<DWRITE_MEASURING_MODE> {
		DWRITE_MEASURING_MODE_NATURAL(0),
		DWRITE_MEASURING_MODE_GDI_CLASSIC(1),
		DWRITE_MEASURING_MODE_GDI_NATURAL(2);
		
		public final long value;
		DWRITE_MEASURING_MODE(long value) {
			this.value = value;
		}
		public long value() {
			return value;
		}
		public Iterator<DWRITE_MEASURING_MODE > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<DWRITE_MEASURING_MODE > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	};
}

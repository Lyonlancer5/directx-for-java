package com.fourthskyinteractive.dx4j.dxgi;

import static org.bridj.Pointer.allocatePointer;
import static org.bridj.Pointer.pointerToAddress;

import java.awt.Component;
import java.util.Collections;
import java.util.Iterator;

import org.bridj.BridJ;
import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.ValuedEnum;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.jawt.JAWTUtils;

import com.fourthskyinteractive.dx4j.dxgi.device.DXGI_SWAP_CHAIN_DESC;
import com.fourthskyinteractive.dx4j.windows.HWND;

/**
 * Wrapper for library <b>dxgi</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.free.fr/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("dxgi") 
@Runtime(COMRuntime.class) 
public class DXGI {
	static {
		BridJ.register();
	}
	
	public enum DXGI_MODE_SCALING implements IntValuedEnum<DXGI_MODE_SCALING > {
		DXGI_MODE_SCALING_UNKNOWN(99999);
		DXGI_MODE_SCALING(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_MODE_SCALING > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<DXGI_MODE_SCALING > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	
	public enum DXGI_MODE_SCANLINE_ORDER implements IntValuedEnum<DXGI_MODE_SCANLINE_ORDER > {
		DXGI_MODE_SCANLINE_ORDER_UNSPECIFIED(0),
		DXGI_MODE_SCANLINE_ORDER_PROGRESSIVE(1),
		DXGI_MODE_SCANLINE_ORDER_UPPER_FIELD_FIRST(2),
		DXGI_MODE_SCANLINE_ORDER_LOWER_FIELD_FIRST(3);
		DXGI_MODE_SCANLINE_ORDER(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_MODE_SCANLINE_ORDER > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<DXGI_MODE_SCANLINE_ORDER > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	public enum DXGI_FORMAT implements IntValuedEnum<DXGI_FORMAT > {
		DXGI_FORMAT_FROM_FILE(-3),
		DXGI_FORMAT_UNKNOWN(0),
		DXGI_FORMAT_R32G32B32A32_TYPELESS(1),
		DXGI_FORMAT_R32G32B32A32_FLOAT(2),
		DXGI_FORMAT_R32G32B32A32_UINT(3),
		DXGI_FORMAT_R32G32B32A32_SINT(4),
		DXGI_FORMAT_R32G32B32_TYPELESS(5),
		DXGI_FORMAT_R32G32B32_FLOAT(6),
		DXGI_FORMAT_R32G32B32_UINT(7),
		DXGI_FORMAT_R32G32B32_SINT(8),
		DXGI_FORMAT_R16G16B16A16_TYPELESS(9),
		DXGI_FORMAT_R16G16B16A16_FLOAT(10),
		DXGI_FORMAT_R16G16B16A16_UNORM(11),
		DXGI_FORMAT_R16G16B16A16_UINT(12),
		DXGI_FORMAT_R16G16B16A16_SNORM(13),
		DXGI_FORMAT_R16G16B16A16_SINT(14),
		DXGI_FORMAT_R32G32_TYPELESS(15),
		DXGI_FORMAT_R32G32_FLOAT(16),
		DXGI_FORMAT_R32G32_UINT(17),
		DXGI_FORMAT_R32G32_SINT(18),
		DXGI_FORMAT_R32G8X24_TYPELESS(19),
		DXGI_FORMAT_D32_FLOAT_S8X24_UINT(20),
		DXGI_FORMAT_R32_FLOAT_X8X24_TYPELESS(21),
		DXGI_FORMAT_X32_TYPELESS_G8X24_UINT(22),
		DXGI_FORMAT_R10G10B10A2_TYPELESS(23),
		DXGI_FORMAT_R10G10B10A2_UNORM(24),
		DXGI_FORMAT_R10G10B10A2_UINT(25),
		DXGI_FORMAT_R11G11B10_FLOAT(26),
		DXGI_FORMAT_R8G8B8A8_TYPELESS(27),
		DXGI_FORMAT_R8G8B8A8_UNORM(28),
		DXGI_FORMAT_R8G8B8A8_UNORM_SRGB(29),
		DXGI_FORMAT_R8G8B8A8_UINT(30),
		DXGI_FORMAT_R8G8B8A8_SNORM(31),
		DXGI_FORMAT_R8G8B8A8_SINT(32),
		DXGI_FORMAT_R16G16_TYPELESS(33),
		DXGI_FORMAT_R16G16_FLOAT(34),
		DXGI_FORMAT_R16G16_UNORM(35),
		DXGI_FORMAT_R16G16_UINT(36),
		DXGI_FORMAT_R16G16_SNORM(37),
		DXGI_FORMAT_R16G16_SINT(38),
		DXGI_FORMAT_R32_TYPELESS(39),
		DXGI_FORMAT_D32_FLOAT(40),
		DXGI_FORMAT_R32_FLOAT(41),
		DXGI_FORMAT_R32_UINT(42),
		DXGI_FORMAT_R32_SINT(43),
		DXGI_FORMAT_R24G8_TYPELESS(44),
		DXGI_FORMAT_D24_UNORM_S8_UINT(45),
		DXGI_FORMAT_R24_UNORM_X8_TYPELESS(46),
		DXGI_FORMAT_X24_TYPELESS_G8_UINT(47),
		DXGI_FORMAT_R8G8_TYPELESS(48),
		DXGI_FORMAT_R8G8_UNORM(49),
		DXGI_FORMAT_R8G8_UINT(50),
		DXGI_FORMAT_R8G8_SNORM(51),
		DXGI_FORMAT_R8G8_SINT(52),
		DXGI_FORMAT_R16_TYPELESS(53),
		DXGI_FORMAT_R16_FLOAT(54),
		DXGI_FORMAT_D16_UNORM(55),
		DXGI_FORMAT_R16_UNORM(56),
		DXGI_FORMAT_R16_UINT(57),
		DXGI_FORMAT_R16_SNORM(58),
		DXGI_FORMAT_R16_SINT(59),
		DXGI_FORMAT_R8_TYPELESS(60),
		DXGI_FORMAT_R8_UNORM(61),
		DXGI_FORMAT_R8_UINT(62),
		DXGI_FORMAT_R8_SNORM(63),
		DXGI_FORMAT_R8_SINT(64),
		DXGI_FORMAT_A8_UNORM(65),
		DXGI_FORMAT_R1_UNORM(66),
		DXGI_FORMAT_R9G9B9E5_SHAREDEXP(67),
		DXGI_FORMAT_R8G8_B8G8_UNORM(68),
		DXGI_FORMAT_G8R8_G8B8_UNORM(69),
		DXGI_FORMAT_BC1_TYPELESS(70),
		DXGI_FORMAT_BC1_UNORM(71),
		DXGI_FORMAT_BC1_UNORM_SRGB(72),
		DXGI_FORMAT_BC2_TYPELESS(73),
		DXGI_FORMAT_BC2_UNORM(74),
		DXGI_FORMAT_BC2_UNORM_SRGB(75),
		DXGI_FORMAT_BC3_TYPELESS(76),
		DXGI_FORMAT_BC3_UNORM(77),
		DXGI_FORMAT_BC3_UNORM_SRGB(78),
		DXGI_FORMAT_BC4_TYPELESS(79),
		DXGI_FORMAT_BC4_UNORM(80),
		DXGI_FORMAT_BC4_SNORM(81),
		DXGI_FORMAT_BC5_TYPELESS(82),
		DXGI_FORMAT_BC5_UNORM(83),
		DXGI_FORMAT_BC5_SNORM(84),
		DXGI_FORMAT_B5G6R5_UNORM(85),
		DXGI_FORMAT_B5G5R5A1_UNORM(86),
		DXGI_FORMAT_B8G8R8A8_UNORM(87),
		DXGI_FORMAT_B8G8R8X8_UNORM(88),
		DXGI_FORMAT_R10G10B10_XR_BIAS_A2_UNORM(89),
		DXGI_FORMAT_B8G8R8A8_TYPELESS(90),
		DXGI_FORMAT_B8G8R8A8_UNORM_SRGB(91),
		DXGI_FORMAT_B8G8R8X8_TYPELESS(92),
		DXGI_FORMAT_B8G8R8X8_UNORM_SRGB(93),
		DXGI_FORMAT_BC6H_TYPELESS(94),
		DXGI_FORMAT_BC6H_UF16(95),
		DXGI_FORMAT_BC6H_SF16(96),
		DXGI_FORMAT_BC7_TYPELESS(97),
		DXGI_FORMAT_BC7_UNORM(98),
		DXGI_FORMAT_BC7_UNORM_SRGB(99);
	
		DXGI_FORMAT(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_FORMAT > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<DXGI_FORMAT> fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	public enum DXGI_RESIDENCY implements IntValuedEnum<DXGI_RESIDENCY > {
		DXGI_RESIDENCY_FULLY_RESIDENT(1),
		DXGI_RESIDENCY_RESIDENT_IN_SHARED_MEMORY(2),
		DXGI_RESIDENCY_EVICTED_TO_DISK(3);
		DXGI_RESIDENCY(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_RESIDENCY > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<DXGI_RESIDENCY > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	public enum DXGI_SWAP_EFFECT implements IntValuedEnum<DXGI_SWAP_EFFECT > {
		DXGI_SWAP_EFFECT_DISCARD(0),
		DXGI_SWAP_EFFECT_SEQUENTIAL(1);
		DXGI_SWAP_EFFECT(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_SWAP_EFFECT > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<DXGI_SWAP_EFFECT > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	public enum DXGI_SWAP_CHAIN_FLAG implements IntValuedEnum<DXGI_SWAP_CHAIN_FLAG > {
		DXGI_SWAP_CHAIN_FLAG_NONPREROTATED(1),
		DXGI_SWAP_CHAIN_FLAG_ALLOW_MODE_SWITCH(2),
		DXGI_SWAP_CHAIN_FLAG_GDI_COMPATIBLE(4);
		DXGI_SWAP_CHAIN_FLAG(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_SWAP_CHAIN_FLAG > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<DXGI_SWAP_CHAIN_FLAG > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	public enum DXGI_ADAPTER_FLAG implements IntValuedEnum<DXGI_ADAPTER_FLAG > {
		DXGI_ADAPTER_FLAG_NONE(0),
		DXGI_ADAPTER_FLAG_REMOTE(1),
		DXGI_ADAPTER_FLAG_FORCE_DWORD(0xFFFFFFFF);
		DXGI_ADAPTER_FLAG(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_ADAPTER_FLAG > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static ValuedEnum<DXGI_ADAPTER_FLAG > fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	public enum DXGI_USAGE implements IntValuedEnum<DXGI_USAGE> {
		DXGI_USAGE_SHADER_INPUT(1 << (0 + 4)),
		DXGI_USAGE_RENDER_TARGET_OUTPUT(1 << (1 + 4)),
		DXGI_USAGE_BACK_BUFFER(1 << (2 + 4)),
		DXGI_USAGE_SHARED(1 << (3 + 4)),
		DXGI_USAGE_READ_ONLY(1 << (4 + 4)),
		DXGI_USAGE_DISCARD_ON_PRESENT(1 << (5 + 4)),
		DXGI_USAGE_UNORDERED_ACCESS(1 << (6 + 4));
		DXGI_USAGE(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_USAGE> iterator() {
			return Collections.singleton(this).iterator();
		}
		public static FlagSet<DXGI_USAGE> fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	
	public enum DXGI_CPU_ACCESS implements IntValuedEnum<DXGI_CPU_ACCESS> {
		DXGI_CPU_ACCESS_NONE(0),
		DXGI_CPU_ACCESS_DYNAMIC(1),
		DXGI_CPU_ACCESS_READ_WRITE(2),
		DXGI_CPU_ACCESS_SCRATCH(3),
		DDXGI_CPU_ACCESS_FIELD(4);
		DXGI_CPU_ACCESS(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_CPU_ACCESS> iterator() {
			return Collections.singleton(this).iterator();
		}
		public static FlagSet<DXGI_CPU_ACCESS> fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	
	public enum DXGI_SCALING implements IntValuedEnum<DXGI_SCALING> {
		DXGI_SCALING_STRETCH(0),
		DXGI_SCALING_NONE(1);
		DXGI_SCALING(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_SCALING> iterator() {
			return Collections.singleton(this).iterator();
		}
		public static FlagSet<DXGI_SCALING> fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	
	public enum DXGI_ALPHA_MODE implements IntValuedEnum<DXGI_ALPHA_MODE> {
		DXGI_ALPHA_MODE_UNSPECIFIED(0),
		DXGI_ALPHA_MODE_PREMULTIPLIED(1),
		DXGI_ALPHA_MODE_STRAIGHT(2),
		DXGI_ALPHA_MODE_IGNORE(3);
		DXGI_ALPHA_MODE(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_ALPHA_MODE> iterator() {
			return Collections.singleton(this).iterator();
		}
		public static FlagSet<DXGI_ALPHA_MODE> fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	
	public enum DXGI_GRAPHICS_PREEMPTION_GRANULARITY implements IntValuedEnum<DXGI_GRAPHICS_PREEMPTION_GRANULARITY> {
		DXGI_GRAPHICS_PREEMPTION_DMA_BUFFER_BOUNDARY(0),
		DXGI_GRAPHICS_PREEMPTION_PRIMITIVE_BOUNDARY(1),
		DXGI_GRAPHICS_PREEMPTION_TRIANGLE_BOUNDARY(2),
		DXGI_GRAPHICS_PREEMPTION_PIXEL_BOUNDARY(3),
		DXGI_GRAPHICS_PREEMPTION_INSTRUCTION_BOUNDARY(4);
		DXGI_GRAPHICS_PREEMPTION_GRANULARITY(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_GRAPHICS_PREEMPTION_GRANULARITY> iterator() {
			return Collections.singleton(this).iterator();
		}
		public static FlagSet<DXGI_GRAPHICS_PREEMPTION_GRANULARITY> fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	
	public enum DXGI_COMPUTE_PREEMPTION_GRANULARITY implements IntValuedEnum<DXGI_COMPUTE_PREEMPTION_GRANULARITY> {
		DXGI_COMPUTE_PREEMPTION_DMA_BUFFER_BOUNDARY(0),
		DXGI_COMPUTE_PREEMPTION_DISPATCH_BOUNDARY(1),
		DXGI_COMPUTE_PREEMPTION_THREAD_GROUP_BOUNDARY(2),
		DXGI_COMPUTE_PREEMPTION_THREAD_BOUNDARY(3),
		DXGI_COMPUTE_PREEMPTION_INSTRUCTION_BOUNDARY(4);
		DXGI_COMPUTE_PREEMPTION_GRANULARITY(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_COMPUTE_PREEMPTION_GRANULARITY> iterator() {
			return Collections.singleton(this).iterator();
		}
		public static FlagSet<DXGI_COMPUTE_PREEMPTION_GRANULARITY> fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	
	public enum DXGI_OFFER_RESOURCE_PRIORITY implements IntValuedEnum<DXGI_OFFER_RESOURCE_PRIORITY> {
		DXGI_OFFER_RESOURCE_PRIORITY_LOW(1),
		DXGI_OFFER_RESOURCE_PRIORITY_NORMAL(2),
		DXGI_OFFER_RESOURCE_PRIORITY_HIGH(3);
		DXGI_OFFER_RESOURCE_PRIORITY(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_OFFER_RESOURCE_PRIORITY> iterator() {
			return Collections.singleton(this).iterator();
		}
		public static FlagSet<DXGI_OFFER_RESOURCE_PRIORITY> fromValue(long value) {
			return FlagSet.fromValue(value, values());
		}
	}
	
	public enum DXGI_MODE_ROTATION implements IntValuedEnum<DXGI_MODE_ROTATION > {
		DXGI_MODE_ROTATION_UNSPECIFIED(0),
		DXGI_MODE_ROTATION_IDENTITY(1),
		DXGI_MODE_ROTATION_ROTATE90(2),
		DXGI_MODE_ROTATION_ROTATE180(3),
		DXGI_MODE_ROTATION_ROTATE270(4);
		DXGI_MODE_ROTATION(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<DXGI_MODE_ROTATION > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static IntValuedEnum<DXGI_MODE_ROTATION > fromValue(int value) {
			return FlagSet.fromValue(value, values());
		}
	}

    public enum DXGI_OUTDUPL_POINTER_SHAPE_TYPE implements IntValuedEnum<DXGI_OUTDUPL_POINTER_SHAPE_TYPE > {
        DXGI_OUTDUPL_POINTER_SHAPE_TYPE_MONOCHROME(0x1),
        DXGI_OUTDUPL_POINTER_SHAPE_TYPE_COLOR(0x2),
        DXGI_OUTDUPL_POINTER_SHAPE_TYPE_MASKED_COLOR(0x4);
        DXGI_OUTDUPL_POINTER_SHAPE_TYPE(long value) {
            this.value = value;
        }
        public final long value;
        public long value() {
            return this.value;
        }
        public Iterator<DXGI_OUTDUPL_POINTER_SHAPE_TYPE > iterator() {
            return Collections.singleton(this).iterator();
        }
        public static IntValuedEnum<DXGI_OUTDUPL_POINTER_SHAPE_TYPE > fromValue(int value) {
            return FlagSet.fromValue(value, values());
        }
    }
	
	// DXGI error codes
	public static final int DXGI_ERROR_DRIVER_INTERNAL_ERROR = 0x887A0020;
	public static final int DXGI_ERROR_FRAME_STATISTICS_DISJOINT = 0x887A000B;
	public static final int DXGI_ERROR_GRAPHICS_VIDPN_SOURCE_IN_USE = 0x887A000C;
	public static final int DXGI_ERROR_INVALID_CALL = 0x887A0001;
	public static final int DXGI_ERROR_MORE_DATA = 0x887A0003;
	public static final int DXGI_ERROR_NONEXCLUSIVE = 0x887A0021;
	public static final int DXGI_ERROR_NOT_CURRENTLY_AVAILABLE = 0x887A0022;
	public static final int DXGI_ERROR_NOT_FOUND = 0x887A0002;
	public static final int DXGI_ERROR_REMOTE_CLIENT_DISCONNECTED = 0x887A0023;
	public static final int DXGI_ERROR_REMOTE_OUTOFMEMORY = 0x887A0024;
	public static final int DXGI_ERROR_WAS_STILL_DRAWING = 0x887A000A;
	public static final int DXGI_ERROR_UNSUPPORTED = 0x887A0004;
	public static final int DXGI_ERROR_ACCESS_LOST = 0x887A0026;
	public static final int DXGI_ERROR_WAIT_TIMEOUT = 0x887A0027;
	public static final int DXGI_ERROR_SESSION_DISCONNECTED = 0x887A0028;
	public static final int DXGI_ERROR_RESTRICT_TO_OUTPUT_STALE = 0x887A0029;
	public static final int DXGI_ERROR_CANNOT_PROTECT_CONTENT = 0x887A002A;
	public static final int DXGI_ERROR_ACCESS_DENIED = 0x887A002B;
	public static final int DXGI_ERROR_NAME_ALREADY_EXISTS = 0x887A002C;

	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_RESOURCE_PRIORITY_NORMAL = (int)(2013265920);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_CPU_ACCESS_DYNAMIC = (int)(1);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_CPU_ACCESS_SCRATCH = (int)(3);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_PRESENT_RESTART = (int)4;
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_MAP_READ = (int)(1);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_MAP_WRITE = (int)(2);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_MWA_NO_PRINT_SCREEN = (int)(1 << 2);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_MWA_NO_ALT_ENTER = (int)(1 << 1);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_CPU_ACCESS_NONE = (int)(0);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_PRESENT_DO_NOT_SEQUENCE = (int)2;
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_RESOURCE_PRIORITY_HIGH = (int)(-1610612736);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_PRESENT_TEST = (int)1;
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_MAP_DISCARD = (int)(4);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_RESOURCE_PRIORITY_MAXIMUM = (int)(-939524096);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_CPU_ACCESS_FIELD = (int)15;
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_CPU_ACCESS_READ_WRITE = (int)(2);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_ENUM_MODES_INTERLACED = (int)(1);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_MWA_VALID = (int)(7);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_MAX_SWAP_CHAIN_BUFFERS = (int)(16);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_RESOURCE_PRIORITY_LOW = (int)(1342177280);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_ENUM_MODES_SCALING = (int)(2);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_RESOURCE_PRIORITY_MINIMUM = (int)(671088640);
	/// <i>native declaration : DXGI.h</i>
	public static final int DXGI_MWA_NO_WINDOW_CHANGES = (int)(1 << 0);

    public static final int DXGI_ENUM_MODES_STEREO			= 4;
    public static final int DXGI_ENUM_MODES_DISABLED_STEREO	= 8;
    public static final int DXGI_SHARED_RESOURCE_READ		= 0x80000000;
    public static final int DXGI_SHARED_RESOURCE_WRITE		= 1;
	
	@Deprecated
	public static native int CreateDXGIFactory(Pointer<Byte> riid, Pointer<Pointer<?> > ppFactory);
	@Deprecated
	public static native int CreateDXGIFactory1(Pointer<Byte> pointer, Pointer<Pointer<?>> ppFactory);
	
	// "Javanized" methods
	public static final IDXGIFactory CreateDXGIFactory() throws DXGIException {
		Pointer<Byte> pGUID = COMRuntime.getIID(IDXGIFactory.class); 
		Pointer<Pointer<?>> pp = allocatePointer();
		
		int result = CreateDXGIFactory(pGUID, pp);
		if(result != 0) {
			pp.release();
			throw new DXGIException(result);
		}
		
		return pp.get().getNativeObject(IDXGIFactory.class);
	}
	
	public static final IDXGIFactory1 CreateDXGIFactory1() throws DXGIException {
		Pointer<Byte> pGUID = COMRuntime.getIID(IDXGIFactory1.class); 
		Pointer<Pointer<?>> pp = allocatePointer();
		
		int result = CreateDXGIFactory1(pGUID, pp);
		if(result != 0) {
			pp.release();
			throw new DXGIException(result);
		}
		
		return pp.get().getNativeObject(IDXGIFactory1.class);
	}
	
	// Utility methods
	public static final DXGI_SWAP_CHAIN_DESC SwapChainDescription(Component comp) {
		DXGI_SWAP_CHAIN_DESC desc = new DXGI_SWAP_CHAIN_DESC();
		desc.BufferCount(1)
			.Windowed(1)
			.OutputWindow(new HWND(pointerToAddress(JAWTUtils.getNativePeerHandle(comp))))
			.BufferUsage(DXGI_USAGE.DXGI_USAGE_RENDER_TARGET_OUTPUT)
			.SwapEffect(DXGI_SWAP_EFFECT.DXGI_SWAP_EFFECT_DISCARD);
		desc.BufferDesc().Width(comp.getWidth())
						 .Height(comp.getHeight())
						 .Format(DXGI_FORMAT.DXGI_FORMAT_R8G8B8A8_UNORM)
						 .RefreshRate().Numerator(60)
						 			   .Denominator(1);
		desc.SampleDesc().Count(1)
						 .Quality(0);
		
		return desc;
	}
	
	public static final DXGI_SWAP_CHAIN_DESC SwapChainDescription(Component comp, DXGI_FORMAT format) {
		DXGI_SWAP_CHAIN_DESC desc = new DXGI_SWAP_CHAIN_DESC();
		desc.BufferCount(1)
			.Windowed(1)
			.OutputWindow(new HWND(pointerToAddress(JAWTUtils.getNativePeerHandle(comp))))
			.BufferUsage(DXGI_USAGE.DXGI_USAGE_RENDER_TARGET_OUTPUT)
			.SwapEffect(DXGI_SWAP_EFFECT.DXGI_SWAP_EFFECT_DISCARD);
		desc.BufferDesc().Width(comp.getWidth())
						 .Height(comp.getHeight())
						 .Format(format)
						 .RefreshRate().Numerator(60)
						 			   .Denominator(1);
		desc.SampleDesc().Count(1)
						 .Quality(0);
		
		return desc;
	}
	
}

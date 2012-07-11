package com.fourthskyinteractive.dx4j.d3d9.core;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;
import org.bridj.cpp.com.IUnknown;
import org.bridj.cpp.com.RECT;

import static org.bridj.Pointer.*;

import com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DFORMAT;
import com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DMULTISAMPLE_TYPE;
import com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DPOOL;
import com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DPRIMITIVETYPE;
import com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DTEXTUREFILTERTYPE;
import com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DTRANSFORMSTATETYPE;
import com.fourthskyinteractive.dx4j.d3d9.D3D9Exception;
import com.fourthskyinteractive.dx4j.d3d9.D3DMATRIX;
import com.fourthskyinteractive.dx4j.d3d9.D3DRASTER_STATUS;
import com.fourthskyinteractive.dx4j.d3d9.D3DRECT;
import com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DBACKBUFFER_TYPE;
import com.fourthskyinteractive.dx4j.d3d9.resources.IDirect3DCubeTexture9;
import com.fourthskyinteractive.dx4j.d3d9.resources.IDirect3DIndexBuffer9;
import com.fourthskyinteractive.dx4j.d3d9.resources.IDirect3DSurface9;
import com.fourthskyinteractive.dx4j.d3d9.resources.IDirect3DTexture9;
import com.fourthskyinteractive.dx4j.d3d9.resources.IDirect3DVertexBuffer9;
import com.fourthskyinteractive.dx4j.d3d9.resources.IDirect3DVolumeTexture9;
import com.fourthskyinteractive.dx4j.windows.HANDLE;
import com.fourthskyinteractive.dx4j.windows.HWND;

@IID("d0223b96-bf7a-43fd-92bd-a43b0d82b9eb")
@Library("d3d9")
@Runtime(COMRuntime.class)
public class IDirect3DDevice9 extends IUnknown {
	
	@Virtual(0)
	public native final int TestCooperativeLevel();
	
	@Virtual(1)
	public native final long GetAvailableTestureMem();
	
	@Virtual(2)
	public native final int EvictManagedResources();
	
	@Virtual(3)
	public native final int GetDirect3D(Pointer<Pointer<IDirect3D9>> ppD3D9);
	
	@Virtual(4)
	public native final int GetDeviceCaps(Pointer<D3DCAPS9> pCaps);
	
	@Virtual(5)
	public native final int GetDisplayMode(int iSwapChain, Pointer<D3DDISPLAYMODE> pMode);
	
	@Virtual(6)
	public native final int GetCreationParameters(Pointer<D3DDEVICE_CREATION_PARAMETERS> pParameters);
	
	@Virtual(7)
	public native final int SetCursorProperties(int XHotSpot, int YHotSpot, Pointer<IDirect3DSurface9> pCursorBitmap);
	
	@Virtual(8)
	public native final int SetCursorPosition(int X, int Y, int Flags);
	
	@Virtual(9)
	public native final int ShowCursor(int bShow);
	
	@Virtual(10)
	public native final int CreateAdditionalSwapChain(Pointer<D3DPRESENT_PARAMETERS> pPresentationParameters, Pointer<Pointer<IDirect3DSwapChain9>> ppSwapChain);
	
	@Virtual(11)
	public native final int GetSwapChain(int iSwapChain, Pointer<Pointer<IDirect3DSwapChain9>> ppSwapChain);
	
	@Virtual(12)
	public native final int GetNumberOfSwapChains();
	
	@Virtual(13)
	public native final int Reset(Pointer<D3DPRESENT_PARAMETERS> pPresentationParameters);
	
	@Virtual(14)
	public native final int Present(Pointer<RECT> pSourceRect,Pointer<RECT> pDestRect, HWND hDestWindowOverride, Pointer</*RGNDATA*/?> pDirtyRegion);
	
	@Virtual(15)
	public native final int GetBackBuffer(int iSwapChain, int iBackBuffer, D3DBACKBUFFER_TYPE Type, Pointer<Pointer<IDirect3DSurface9>> ppBackBuffer);

	@Virtual(16)
	public native final int GetRasterStatus(int iSwapChain, Pointer<D3DRASTER_STATUS> pRasterStatus);
	
	@Virtual(17)
	public native final int SetDialogBoxMode(int bEnableDialogs);
	
	@Virtual(20)
	public native final int CreateTexture(int Width, int Height, int Levels, int Usage, D3DFORMAT Format, D3DPOOL Pool, Pointer<Pointer<IDirect3DTexture9>> ppTexture, Pointer<HANDLE> pSharedHandle);
	
	@Virtual(21)
	public native final int CreateVolumeTexture(int Width, int Height, int Depth, int Levels, int Usage, D3DFORMAT Format, D3DPOOL Pool, Pointer<Pointer<IDirect3DVolumeTexture9>> ppVolumeTexture, Pointer<HANDLE> pSharedHandle);

	@Virtual(22)
	public native final int CreateCubeTexture(int EdgeLength, int Levels, int Usage, D3DFORMAT Format, D3DPOOL Pool, Pointer<Pointer<IDirect3DCubeTexture9>> ppCubeTexture, Pointer<HANDLE> pSharedHandle);
	
	@Deprecated @Virtual(23)
	public native final int CreateVertexBuffer(int length, int Usage, int FVF, D3DPOOL Pool, Pointer<Pointer<IDirect3DVertexBuffer9>> ppVertexBuffer, Pointer<HANDLE> pSharedHandle);
	
	@Virtual(24)
	public native final int CreateIndexBuffer(int Length, int Usage, D3DFORMAT Format, D3DPOOL Pool, Pointer<Pointer<IDirect3DIndexBuffer9>> ppIndexBuffer, Pointer<HANDLE> pSharedHandle);
	
	@Virtual(25)
	public native final int CreateRenderTarget(int Width, int Height, D3DFORMAT Format, D3DMULTISAMPLE_TYPE MultiSample, int MultisampleQuality, int Lockable, Pointer<Pointer<IDirect3DSurface9>> ppSurface, Pointer<HANDLE> pSharedHandle);
	
	@Virtual(26)
	public native final int CreateDepthStencilSurface(int Width, int Height, D3DFORMAT Format, D3DMULTISAMPLE_TYPE MultiSample, int MultisampleQuality, int bDiscard, Pointer<Pointer<IDirect3DSurface9>> ppSurface, Pointer<HANDLE> pSharedHandle);
	
	@Virtual(31)
	public native final int StretchRect(Pointer<IDirect3DSurface9> pSourceSurface, Pointer<RECT> pSourceRect, Pointer<IDirect3DSurface9> pDestSurface, Pointer<RECT> pDestRect, D3DTEXTUREFILTERTYPE Filter);
	
	@Virtual(33)
	public native final int CreateOffscreenPlainSurface(int Width, int Height, D3DFORMAT Format, D3DPOOL Pool, Pointer<Pointer<IDirect3DSurface9>> ppSurface, Pointer<HANDLE> pSharedHandle);
    
	@Virtual(34)
	public native final int SetRenderTarget(int RenderTargetIndex, Pointer<IDirect3DSurface9> pRenderTarget);
	
	/*
    STDMETHOD_(void, SetGammaRamp)(THIS_ UINT iSwapChain,DWORD Flags,CONST D3DGAMMARAMP* pRamp) PURE;
    STDMETHOD_(void, GetGammaRamp)(THIS_ UINT iSwapChain,D3DGAMMARAMP* pRamp) PURE;
    20 STDMETHOD(CreateTexture)(THIS_ UINT Width,UINT Height,UINT Levels,DWORD Usage,D3DFORMAT Format,D3DPOOL Pool,IDirect3DTexture9** ppTexture,HANDLE* pSharedHandle) PURE;
    //STDMETHOD(CreateVolumeTexture)(THIS_ UINT Width,UINT Height,UINT Depth,UINT Levels,DWORD Usage,D3DFORMAT Format,D3DPOOL Pool,IDirect3DVolumeTexture9** ppVolumeTexture,HANDLE* pSharedHandle) PURE;
    //STDMETHOD(CreateCubeTexture)(THIS_ UINT EdgeLength,UINT Levels,DWORD Usage,D3DFORMAT Format,D3DPOOL Pool,IDirect3DCubeTexture9** ppCubeTexture,HANDLE* pSharedHandle) PURE;
    //STDMETHOD(CreateVertexBuffer)(THIS_ UINT Length,DWORD Usage,DWORD FVF,D3DPOOL Pool,IDirect3DVertexBuffer9** ppVertexBuffer,HANDLE* pSharedHandle) PURE;
    //STDMETHOD(CreateIndexBuffer)(THIS_ UINT Length,DWORD Usage,D3DFORMAT Format,D3DPOOL Pool,IDirect3DIndexBuffer9** ppIndexBuffer,HANDLE* pSharedHandle) PURE;
    STDMETHOD(CreateRenderTarget)(THIS_ UINT Width,UINT Height,D3DFORMAT Format,D3DMULTISAMPLE_TYPE MultiSample,DWORD MultisampleQuality,BOOL Lockable,IDirect3DSurface9** ppSurface,HANDLE* pSharedHandle) PURE;
    STDMETHOD(CreateDepthStencilSurface)(THIS_ UINT Width,UINT Height,D3DFORMAT Format,D3DMULTISAMPLE_TYPE MultiSample,DWORD MultisampleQuality,BOOL Discard,IDirect3DSurface9** ppSurface,HANDLE* pSharedHandle) PURE;
    STDMETHOD(UpdateSurface)(THIS_ IDirect3DSurface9* pSourceSurface,CONST RECT* pSourceRect,IDirect3DSurface9* pDestinationSurface,CONST POINT* pDestPoint) PURE;
    STDMETHOD(UpdateTexture)(THIS_ IDirect3DBaseTexture9* pSourceTexture,IDirect3DBaseTexture9* pDestinationTexture) PURE;
    STDMETHOD(GetRenderTargetData)(THIS_ IDirect3DSurface9* pRenderTarget,IDirect3DSurface9* pDestSurface) PURE;
    30 STDMETHOD(GetFrontBufferData)(THIS_ UINT iSwapChain,IDirect3DSurface9* pDestSurface) PURE;
    //STDMETHOD(StretchRect)(THIS_ IDirect3DSurface9* pSourceSurface,CONST RECT* pSourceRect,IDirect3DSurface9* pDestSurface,CONST RECT* pDestRect,D3DTEXTUREFILTERTYPE Filter) PURE;
    STDMETHOD(ColorFill)(THIS_ IDirect3DSurface9* pSurface,CONST RECT* pRect,D3DCOLOR color) PURE;
    STDMETHOD(CreateOffscreenPlainSurface)(THIS_ UINT Width,UINT Height,D3DFORMAT Format,D3DPOOL Pool,IDirect3DSurface9** ppSurface,HANDLE* pSharedHandle) PURE;
    STDMETHOD(SetRenderTarget)(THIS_ DWORD RenderTargetIndex,IDirect3DSurface9* pRenderTarget) PURE;
    STDMETHOD(GetRenderTarget)(THIS_ DWORD RenderTargetIndex,IDirect3DSurface9** ppRenderTarget) PURE;
    STDMETHOD(SetDepthStencilSurface)(THIS_ IDirect3DSurface9* pNewZStencil) PURE;
    STDMETHOD(GetDepthStencilSurface)(THIS_ IDirect3DSurface9** ppZStencilSurface) PURE;
    STDMETHOD(BeginScene)(THIS) PURE;
    STDMETHOD(EndScene)(THIS) PURE;
    40 STDMETHOD(Clear)(THIS_ DWORD Count,CONST D3DRECT* pRects,DWORD Flags,D3DCOLOR Color,float Z,DWORD Stencil) PURE;
    STDMETHOD(SetTransform)(THIS_ D3DTRANSFORMSTATETYPE State,CONST D3DMATRIX* pMatrix) PURE;
    STDMETHOD(GetTransform)(THIS_ D3DTRANSFORMSTATETYPE State,D3DMATRIX* pMatrix) PURE;
    STDMETHOD(MultiplyTransform)(THIS_ D3DTRANSFORMSTATETYPE,CONST D3DMATRIX*) PURE;
    STDMETHOD(SetViewport)(THIS_ CONST D3DVIEWPORT9* pViewport) PURE;
    STDMETHOD(GetViewport)(THIS_ D3DVIEWPORT9* pViewport) PURE;
    STDMETHOD(SetMaterial)(THIS_ CONST D3DMATERIAL9* pMaterial) PURE;
    STDMETHOD(GetMaterial)(THIS_ D3DMATERIAL9* pMaterial) PURE;
    STDMETHOD(SetLight)(THIS_ DWORD Index,CONST D3DLIGHT9*) PURE;
    STDMETHOD(GetLight)(THIS_ DWORD Index,D3DLIGHT9*) PURE;
    50 STDMETHOD(LightEnable)(THIS_ DWORD Index,BOOL Enable) PURE;
    STDMETHOD(GetLightEnable)(THIS_ DWORD Index,BOOL* pEnable) PURE;
    STDMETHOD(SetClipPlane)(THIS_ DWORD Index,CONST float* pPlane) PURE;
    STDMETHOD(GetClipPlane)(THIS_ DWORD Index,float* pPlane) PURE;
    STDMETHOD(SetRenderState)(THIS_ D3DRENDERSTATETYPE State,DWORD Value) PURE;
    STDMETHOD(GetRenderState)(THIS_ D3DRENDERSTATETYPE State,DWORD* pValue) PURE;
    STDMETHOD(CreateStateBlock)(THIS_ D3DSTATEBLOCKTYPE Type,IDirect3DStateBlock9** ppSB) PURE;
    STDMETHOD(BeginStateBlock)(THIS) PURE;
    STDMETHOD(EndStateBlock)(THIS_ IDirect3DStateBlock9** ppSB) PURE;
    STDMETHOD(SetClipStatus)(THIS_ CONST D3DCLIPSTATUS9* pClipStatus) PURE;
    60 STDMETHOD(GetClipStatus)(THIS_ D3DCLIPSTATUS9* pClipStatus) PURE;
    STDMETHOD(GetTexture)(THIS_ DWORD Stage,IDirect3DBaseTexture9** ppTexture) PURE;
    STDMETHOD(SetTexture)(THIS_ DWORD Stage,IDirect3DBaseTexture9* pTexture) PURE;
    STDMETHOD(GetTextureStageState)(THIS_ DWORD Stage,D3DTEXTURESTAGESTATETYPE Type,DWORD* pValue) PURE;
    STDMETHOD(SetTextureStageState)(THIS_ DWORD Stage,D3DTEXTURESTAGESTATETYPE Type,DWORD Value) PURE;
    STDMETHOD(GetSamplerState)(THIS_ DWORD Sampler,D3DSAMPLERSTATETYPE Type,DWORD* pValue) PURE;
    STDMETHOD(SetSamplerState)(THIS_ DWORD Sampler,D3DSAMPLERSTATETYPE Type,DWORD Value) PURE;
    STDMETHOD(ValidateDevice)(THIS_ DWORD* pNumPasses) PURE;
    STDMETHOD(SetPaletteEntries)(THIS_ UINT PaletteNumber,CONST PALETTEENTRY* pEntries) PURE;
    STDMETHOD(GetPaletteEntries)(THIS_ UINT PaletteNumber,PALETTEENTRY* pEntries) PURE;
    70 STDMETHOD(SetCurrentTexturePalette)(THIS_ UINT PaletteNumber) PURE;
    STDMETHOD(GetCurrentTexturePalette)(THIS_ UINT *PaletteNumber) PURE;
    STDMETHOD(SetScissorRect)(THIS_ CONST RECT* pRect) PURE;
    STDMETHOD(GetScissorRect)(THIS_ RECT* pRect) PURE;
    STDMETHOD(SetSoftwareVertexProcessing)(THIS_ BOOL bSoftware) PURE;
    STDMETHOD_(BOOL, GetSoftwareVertexProcessing)(THIS) PURE;
    STDMETHOD(SetNPatchMode)(THIS_ float nSegments) PURE;
    STDMETHOD_(float, GetNPatchMode)(THIS) PURE;
    //STDMETHOD(DrawPrimitive)(THIS_ D3DPRIMITIVETYPE PrimitiveType,UINT StartVertex,UINT PrimitiveCount) PURE;
    STDMETHOD(DrawIndexedPrimitive)(THIS_ D3DPRIMITIVETYPE,INT BaseVertexIndex,UINT MinVertexIndex,UINT NumVertices,UINT startIndex,UINT primCount) PURE;
    80 STDMETHOD(DrawPrimitiveUP)(THIS_ D3DPRIMITIVETYPE PrimitiveType,UINT PrimitiveCount,CONST void* pVertexStreamZeroData,UINT VertexStreamZeroStride) PURE;
    STDMETHOD(DrawIndexedPrimitiveUP)(THIS_ D3DPRIMITIVETYPE PrimitiveType,UINT MinVertexIndex,UINT NumVertices,UINT PrimitiveCount,CONST void* pIndexData,D3DFORMAT IndexDataFormat,CONST void* pVertexStreamZeroData,UINT VertexStreamZeroStride) PURE;
    STDMETHOD(ProcessVertices)(THIS_ UINT SrcStartIndex,UINT DestIndex,UINT VertexCount,IDirect3DVertexBuffer9* pDestBuffer,IDirect3DVertexDeclaration9* pVertexDecl,DWORD Flags) PURE;
    STDMETHOD(CreateVertexDeclaration)(THIS_ CONST D3DVERTEXELEMENT9* pVertexElements,IDirect3DVertexDeclaration9** ppDecl) PURE;
    STDMETHOD(SetVertexDeclaration)(THIS_ IDirect3DVertexDeclaration9* pDecl) PURE;
    STDMETHOD(GetVertexDeclaration)(THIS_ IDirect3DVertexDeclaration9** ppDecl) PURE;
    //STDMETHOD(SetFVF)(THIS_ DWORD FVF) PURE;
    STDMETHOD(GetFVF)(THIS_ DWORD* pFVF) PURE;
    STDMETHOD(CreateVertexShader)(THIS_ CONST DWORD* pFunction,IDirect3DVertexShader9** ppShader) PURE;
    STDMETHOD(SetVertexShader)(THIS_ IDirect3DVertexShader9* pShader) PURE;
    90 STDMETHOD(GetVertexShader)(THIS_ IDirect3DVertexShader9** ppShader) PURE;
    STDMETHOD(SetVertexShaderConstantF)(THIS_ UINT StartRegister,CONST float* pConstantData,UINT Vector4fCount) PURE;
    STDMETHOD(GetVertexShaderConstantF)(THIS_ UINT StartRegister,float* pConstantData,UINT Vector4fCount) PURE;
    STDMETHOD(SetVertexShaderConstantI)(THIS_ UINT StartRegister,CONST int* pConstantData,UINT Vector4iCount) PURE;
    STDMETHOD(GetVertexShaderConstantI)(THIS_ UINT StartRegister,int* pConstantData,UINT Vector4iCount) PURE;
    STDMETHOD(SetVertexShaderConstantB)(THIS_ UINT StartRegister,CONST BOOL* pConstantData,UINT  BoolCount) PURE;
    STDMETHOD(GetVertexShaderConstantB)(THIS_ UINT StartRegister,BOOL* pConstantData,UINT BoolCount) PURE;
    STDMETHOD(SetStreamSource)(THIS_ UINT StreamNumber,IDirect3DVertexBuffer9* pStreamData,UINT OffsetInBytes,UINT Stride) PURE;
    STDMETHOD(GetStreamSource)(THIS_ UINT StreamNumber,IDirect3DVertexBuffer9** ppStreamData,UINT* OffsetInBytes,UINT* pStride) PURE;
    STDMETHOD(SetStreamSourceFreq)(THIS_ UINT StreamNumber,UINT Divider) PURE;
    100 STDMETHOD(GetStreamSourceFreq)(THIS_ UINT StreamNumber,UINT* Divider) PURE;
    STDMETHOD(SetIndices)(THIS_ IDirect3DIndexBuffer9* pIndexData) PURE;
    STDMETHOD(GetIndices)(THIS_ IDirect3DIndexBuffer9** ppIndexData) PURE;
    STDMETHOD(CreatePixelShader)(THIS_ CONST DWORD* pFunction,IDirect3DPixelShader9** ppShader) PURE;
    STDMETHOD(SetPixelShader)(THIS_ IDirect3DPixelShader9* pShader) PURE;
    STDMETHOD(GetPixelShader)(THIS_ IDirect3DPixelShader9** ppShader) PURE;
    STDMETHOD(SetPixelShaderConstantF)(THIS_ UINT StartRegister,CONST float* pConstantData,UINT Vector4fCount) PURE;
    STDMETHOD(GetPixelShaderConstantF)(THIS_ UINT StartRegister,float* pConstantData,UINT Vector4fCount) PURE;
    STDMETHOD(SetPixelShaderConstantI)(THIS_ UINT StartRegister,CONST int* pConstantData,UINT Vector4iCount) PURE;
    STDMETHOD(GetPixelShaderConstantI)(THIS_ UINT StartRegister,int* pConstantData,UINT Vector4iCount) PURE;
    110 STDMETHOD(SetPixelShaderConstantB)(THIS_ UINT StartRegister,CONST BOOL* pConstantData,UINT  BoolCount) PURE;
    STDMETHOD(GetPixelShaderConstantB)(THIS_ UINT StartRegister,BOOL* pConstantData,UINT BoolCount) PURE;
    STDMETHOD(DrawRectPatch)(THIS_ UINT Handle,CONST float* pNumSegs,CONST D3DRECTPATCH_INFO* pRectPatchInfo) PURE;
    STDMETHOD(DrawTriPatch)(THIS_ UINT Handle,CONST float* pNumSegs,CONST D3DTRIPATCH_INFO* pTriPatchInfo) PURE;
    STDMETHOD(DeletePatch)(THIS_ UINT Handle) PURE;
    STDMETHOD(CreateQuery)(THIS_ D3DQUERYTYPE Type,IDirect3DQuery9** ppQuery) PURE;
	 
	 */
	
	@Virtual(38)
	public native final int BeginScene();
	
	@Virtual(39)
	public native final int EndScene();
	
	@Virtual(40)
	public native final int Clear(int Count, Pointer<D3DRECT> pRects, int Flags, /*D3DCOLOR*/ int Color, float Z, int Stencil);
	
	@Virtual(41)
	public native final int SetTransform(D3DTRANSFORMSTATETYPE State,Pointer<D3DMATRIX> pMatrix);
	
	@Virtual(78)
	public native final int DrawPrimitive(D3DPRIMITIVETYPE PrimitiveType, int StartVertex, int PrimitiveCount);
	
	@Virtual(86)
	public native final int SetFVF(int FVF);
	
	@Virtual(97)
	public native final int SetStreamSource(int StreamNumber, Pointer<IDirect3DVertexBuffer9> pStreamData, int OffsetInBytes, int Stride);
	
	public final IDirect3DVertexBuffer9 CreateVertexBuffer(int length, int Usage, int FVF, D3DPOOL Pool) {
		Pointer<Pointer<IDirect3DVertexBuffer9>> pp = allocatePointer(IDirect3DVertexBuffer9.class);
		
		try {
			int result = this.CreateVertexBuffer(length, Usage, FVF, Pool, pp, null);
			if (result != 0) {
				throw new D3D9Exception("Error creating vertex buffer", result);
			}
			
			return pp.get().getNativeObject(IDirect3DVertexBuffer9.class);
		} finally {
			pp.release();
			pp = null;
		}
	}
}

package com.fourthskyinteractive.dx4j.d3d11.core;


import static org.bridj.Pointer.allocateArray;
import static org.bridj.Pointer.allocateInt;
import static org.bridj.Pointer.allocatePointer;
import static org.bridj.Pointer.pointerTo;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;
import org.bridj.cpp.com.IUnknown;

import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_COUNTER_TYPE;
import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D11_FEATURE;
import com.fourthskyinteractive.dx4j.d3d11.D3D11.D3D_FEATURE_LEVEL;
import com.fourthskyinteractive.dx4j.d3d11.D3D11Exception;
import com.fourthskyinteractive.dx4j.d3d11.query.D3D11_COUNTER_DESC;
import com.fourthskyinteractive.dx4j.d3d11.query.D3D11_COUNTER_INFO;
import com.fourthskyinteractive.dx4j.d3d11.query.D3D11_QUERY_DESC;
import com.fourthskyinteractive.dx4j.d3d11.query.ID3D11Counter;
import com.fourthskyinteractive.dx4j.d3d11.query.ID3D11Predicate;
import com.fourthskyinteractive.dx4j.d3d11.query.ID3D11Query;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_BUFFER_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_SUBRESOURCE_DATA;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_TEXTURE1D_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_TEXTURE2D_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.D3D11_TEXTURE3D_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Buffer;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Resource;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Texture1D;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Texture2D;
import com.fourthskyinteractive.dx4j.d3d11.resources.ID3D11Texture3D;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.D3D11_DEPTH_STENCIL_VIEW_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.D3D11_RENDER_TARGET_VIEW_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.D3D11_SHADER_RESOURCE_VIEW_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.D3D11_UNORDERED_ACCESS_VIEW_DESC;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.ID3D11DepthStencilView;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.ID3D11RenderTargetView;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.ID3D11ShaderResourceView;
import com.fourthskyinteractive.dx4j.d3d11.resources.views.ID3D11UnorderedAccessView;
import com.fourthskyinteractive.dx4j.d3d11.shader.D3D11_SO_DECLARATION_ENTRY;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11ClassLinkage;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11ComputeShader;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11DomainShader;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11GeometryShader;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11HullShader;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11PixelShader;
import com.fourthskyinteractive.dx4j.d3d11.shader.ID3D11VertexShader;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_BLEND_DESC;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_DEPTH_STENCIL_DESC;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_INPUT_ELEMENT_DESC;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_RASTERIZER_DESC;
import com.fourthskyinteractive.dx4j.d3d11.states.D3D11_SAMPLER_DESC;
import com.fourthskyinteractive.dx4j.d3d11.states.ID3D11BlendState;
import com.fourthskyinteractive.dx4j.d3d11.states.ID3D11DepthStencilState;
import com.fourthskyinteractive.dx4j.d3d11.states.ID3D11InputLayout;
import com.fourthskyinteractive.dx4j.d3d11.states.ID3D11RasterizerState;
import com.fourthskyinteractive.dx4j.d3d11.states.ID3D11SamplerState;
import com.fourthskyinteractive.dx4j.dxgi.DXGI.DXGI_FORMAT;
import com.fourthskyinteractive.dx4j.windows.HANDLE;

@IID("db6f6ddb-ac77-4e88-8253-819df9bbf140")
@Library("d3d11")
@Runtime(COMRuntime.class)
public class ID3D11Device extends IUnknown {
	public ID3D11Device() {
		super();
	}
//	public ID3D11Device(Pointer<? extends IUnknown> peer) {
//		super(peer);
//	}
	@Deprecated	@Virtual(0)
	public native int CreateBuffer(Pointer<D3D11_BUFFER_DESC> pDesc, Pointer<D3D11_SUBRESOURCE_DATA> pInitialData, Pointer<Pointer<ID3D11Buffer>> ppBuffer);
	@Deprecated	@Virtual(1)
	public native int CreateTexture1D(Pointer<D3D11_TEXTURE1D_DESC> pDesc, Pointer<D3D11_SUBRESOURCE_DATA> pInitialData, Pointer<Pointer<ID3D11Texture1D>> ppTexture);
	@Deprecated	@Virtual(2)
	public native int CreateTexture2D(Pointer<D3D11_TEXTURE2D_DESC> pDesc, Pointer<D3D11_SUBRESOURCE_DATA> pInitialData, Pointer<Pointer<ID3D11Texture2D>> ppTexture);
	@Deprecated	@Virtual(3)
	public native int CreateTexture3D(Pointer<D3D11_TEXTURE3D_DESC> pDesc, Pointer<D3D11_SUBRESOURCE_DATA> pInitialData, Pointer<Pointer<ID3D11Texture3D>> ppTexture);
	@Deprecated	@Virtual(4)
	public native int CreateShaderResourceView(Pointer<? extends ID3D11Resource> pResource, Pointer<D3D11_SHADER_RESOURCE_VIEW_DESC> pDesc, Pointer<Pointer<ID3D11ShaderResourceView>> ppView);
	@Deprecated	@Virtual(5)
	public native int CreateUnorderedAccessView(Pointer<? extends ID3D11Resource> pResource, Pointer<D3D11_UNORDERED_ACCESS_VIEW_DESC> pDesc, Pointer<Pointer<ID3D11UnorderedAccessView>> ppView);
	@Deprecated	@Virtual(6)
	public native int CreateRenderTargetView(Pointer<? extends ID3D11Resource> pResource, Pointer<D3D11_RENDER_TARGET_VIEW_DESC> pDesc, Pointer<Pointer<ID3D11RenderTargetView>> ppView);
	@Deprecated	@Virtual(7)
	public native int CreateDepthStencilView(Pointer<? extends ID3D11Resource> pResource, Pointer<D3D11_DEPTH_STENCIL_VIEW_DESC> pDesc, Pointer<Pointer<ID3D11DepthStencilView>> ppView);
	@Deprecated	@Virtual(8)
	public native int CreateInputLayout(Pointer<D3D11_INPUT_ELEMENT_DESC> pDescs, int NumElements, Pointer<?> pShaderBytecodeWithInputSignature, int BytecodeLength, Pointer<Pointer<ID3D11InputLayout>> ppLayout);
	@Deprecated	@Virtual(9)
	public native int CreateVertexShader(Pointer<?> pShaderBytecode, int BytecodeLength, Pointer<ID3D11ClassLinkage> pLinkage, Pointer<Pointer<ID3D11VertexShader>> ppVertexShader);
	@Deprecated	@Virtual(10)
	public native int CreateGeometryShader(Pointer<?> pShaderBytecode, int BytecodeLength, Pointer<ID3D11ClassLinkage> pLinkage, Pointer<Pointer<ID3D11GeometryShader>> ppGeometryShader);
	@Deprecated	@Virtual(11)
	public native int CreateGeometryShaderWithStreamOutput(Pointer<?> pShaderBytecode, int BytecodeLength, Pointer<D3D11_SO_DECLARATION_ENTRY> pSODeclaration, int NumEntries, Pointer<Integer> pBufferStrides, int NumStrides, int RasterizedStream, Pointer<ID3D11ClassLinkage> pLinkage, Pointer<Pointer<ID3D11GeometryShader>> ppGeometryShader);
	@Deprecated	@Virtual(12)
	public native int CreatePixelShader(Pointer<?> pShaderBytecode, int BytecodeLength, Pointer<ID3D11ClassLinkage> pLinkage, Pointer<Pointer<ID3D11PixelShader>> ppVertexShader);
	@Deprecated	@Virtual(13)
	public native int CreateHullShader(Pointer<?> pShaderBytecode, int BytecodeLength, Pointer<ID3D11ClassLinkage> pLinkage, Pointer<Pointer<ID3D11HullShader>> ppVertexShader);
	@Deprecated	@Virtual(14)
	public native int CreateDomainShader(Pointer<?> pShaderBytecode, int BytecodeLength, Pointer<ID3D11ClassLinkage> pLinkage, Pointer<Pointer<ID3D11DomainShader>> ppVertexShader);
	@Deprecated	@Virtual(15)
	public native int CreateComputeShader(Pointer<?> pShaderBytecode, int BytecodeLength, Pointer<ID3D11ClassLinkage> pLinkage, Pointer<Pointer<ID3D11ComputeShader>> ppVertexShader);
	@Deprecated	@Virtual(16)
	public native int CreateClassLinkage(Pointer<Pointer<ID3D11ClassLinkage>> ppLinkage);
	@Deprecated	@Virtual(17)
	public native int CreateBlendState(Pointer<D3D11_BLEND_DESC> pDesc, Pointer<Pointer<ID3D11BlendState>> ppBlendState);
	@Deprecated	@Virtual(18)
	public native int CreateDepthStencilState(Pointer<D3D11_DEPTH_STENCIL_DESC> pDesc, Pointer<Pointer<ID3D11DepthStencilState>> ppDepthStencilState);
	@Deprecated	@Virtual(19)
	public native int CreateRasterizerState(Pointer<D3D11_RASTERIZER_DESC> pDesc, Pointer<Pointer<ID3D11RasterizerState>> ppRasterizerState);
	@Deprecated	@Virtual(20)
	public native int CreateSamplerState(Pointer<D3D11_SAMPLER_DESC> pDesc, Pointer<Pointer<ID3D11SamplerState>> ppRasterizerState);
	@Deprecated	@Virtual(21)
	public native int CreateQuery(Pointer<D3D11_QUERY_DESC> pDesc, Pointer<Pointer<ID3D11Query>> ppQuery);
	@Deprecated	@Virtual(22)
	public native int CreatePredicate(Pointer<D3D11_QUERY_DESC> pDesc, Pointer<Pointer<ID3D11Predicate>> ppPredicate);
	@Deprecated	@Virtual(23)
	public native int CreateCounter(Pointer<D3D11_COUNTER_DESC> pDesc, Pointer<Pointer<ID3D11Counter>> ppCounter);
	@Deprecated	@Virtual(24)
	public native int CreateDeferredContext(int ContextFlags, Pointer<Pointer<ID3D11DeviceContext>> ppContext);
	@Deprecated @Virtual(25)
	public native <R extends ID3D11Resource> int OpenSharedResource(HANDLE hResource, Pointer<Byte> ReturnedInterface, Pointer<Pointer<R>> ppResource);
	@Deprecated @Virtual(26)
	public native int CheckFormatSupport(DXGI_FORMAT Format, Pointer<Integer> pFormatSupport);
	@Deprecated @Virtual(27)
	public native int CheckMultisampleQualityLevels(DXGI_FORMAT Format, int SampleCount, Pointer<Integer> pNumQualityLevels);
	@Virtual(28)
	public native int CheckCounterInfo(Pointer<D3D11_COUNTER_INFO> pCounterInfo);
	@Virtual(29)
	public native int CheckCounter(Pointer<D3D11_COUNTER_DESC> pDesc, Pointer<D3D11_COUNTER_TYPE> pType, Pointer<Integer> pActiveCounters, Pointer<Byte> szName, Pointer<Integer> pNameLength, Pointer<Byte> szUnits, Pointer<Integer> pUnitsLength, Pointer<Byte> szDescription, Pointer<Integer> pDescriptionLength);
	@Virtual(30)
	public native int CheckFeatureSupport(D3D11_FEATURE Feature, Pointer<?> pFeatureSupportData);
	@Virtual(31)
	public native int GetPrivateData(Pointer<Byte> guid, Pointer<Integer> pDataSize, Pointer<?> pData);
	@Virtual(32)
	public native int SetPrivateData(Pointer<Byte> guid, Pointer<Integer> pDataSize, Pointer<?> pData);
	@Virtual(33)
	public native int SetPrivateDataInterface(Pointer<Byte> guid, Pointer<IUnknown> pData);
	@Virtual(34)
	public native D3D_FEATURE_LEVEL GetFeatureLevel();
	@Virtual(35)
	public native int GetCreationFlags();
    @Virtual(36)
    public native int GetDeviceRemovedReason();
    @Deprecated @Virtual(37)
    public native void GetImmediateContext(Pointer<Pointer<ID3D11DeviceContext>> ppImmediateContext);
    @Virtual(38)
    public native int SetExceptionMode(int RaiseFlags);
    @Virtual(39)
    public native int GetExceptionMode();
    
    // "Javanized" methods
    public final ID3D11DeviceContext CreateDeferredContext(int ContextFlags) {
    	Pointer<Pointer<ID3D11DeviceContext>> pp = allocatePointer(ID3D11DeviceContext.class);
    	try {
    		int result = CreateDeferredContext(ContextFlags, pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create deferred context", result);
    		}
    		
    		return pp.get().getNativeObject(ID3D11DeviceContext.class);
    	} finally {
   			pp.release();
   			pp = null;
    	}
    }
    
    public final ID3D11RenderTargetView CreateRenderTargetView(ID3D11Resource resource, D3D11_RENDER_TARGET_VIEW_DESC desc) {
    	Pointer<Pointer<ID3D11RenderTargetView>> pp = allocatePointer(ID3D11RenderTargetView.class);
    	try {
    		int result = CreateRenderTargetView(pointerTo(resource), pointerTo(desc), pp);
    		if(result != 0) {
    			throw new D3D11Exception("", result);
    		}
    		
    		return pp.get().getNativeObject(ID3D11RenderTargetView.class);
    	} finally {
   			pp.release();
   			pp = null;
    	}
    }
    
    public final ID3D11DeviceContext GetImmediateContext() {
    	Pointer<Pointer<ID3D11DeviceContext>> ppImmediateContext =  allocatePointer(ID3D11DeviceContext.class);;
    	try {
    		GetImmediateContext(ppImmediateContext);
    		return ppImmediateContext.get().getNativeObject(ID3D11DeviceContext.class);
    	} finally {
    		if(ppImmediateContext != null) {
    			ppImmediateContext.release();
    		}
    	}
    }
    
    public final ID3D11InputLayout CreateInputLayout(D3D11_INPUT_ELEMENT_DESC[] descs, ID3D10Blob shaderCode) {
    	Pointer<Pointer<ID3D11InputLayout>> pp = allocatePointer(ID3D11InputLayout.class);
    	Pointer<D3D11_INPUT_ELEMENT_DESC> pDescs = allocateArray(D3D11_INPUT_ELEMENT_DESC.class, descs.length);
    	
    	try {
    		// Pointer.pointerToArray crashes the program, so copy manually every element
    		for(int i = 0; i < descs.length; i++) {
    			pDescs.get(i).SemanticName(descs[i].SemanticName())
							  .SemanticIndex(descs[i].SemanticIndex())
							  .Format(descs[i].Format())
							  .InputSlot(descs[i].InputSlot())
							  .AlignedByteOffset(descs[i].AlignedByteOffset())
							  .InputSlotClass(descs[i].InputSlotClass())
							  .InstanceDataStepRate(descs[i].InstanceDataStepRate());
    		}
    		int result = CreateInputLayout(pDescs, descs.length, shaderCode.GetBufferPointer(), (int) shaderCode.GetBufferSize(), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create input layout", result);
    		}
    		
    		return pp.get().getNativeObject(ID3D11InputLayout.class);
    	} finally {
    		pDescs.release();
    		pDescs = null;
    		pp.release();
   			pp = null;
    	}
    }
    
    public final ID3D11ClassLinkage CreateClassLinkage() {
    	Pointer<Pointer<ID3D11ClassLinkage>> pp = allocatePointer(ID3D11ClassLinkage.class);
    	try {
    		int result = this.CreateClassLinkage(pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create class linkage", result);
    		}    		
    		
    		return pp.get().getNativeObject(ID3D11ClassLinkage.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    }
    
    public final ID3D11VertexShader CreateVertexShader(ID3D10Blob compiledCode, ID3D11ClassLinkage linkage) {
    	Pointer<Pointer<ID3D11VertexShader>> pp = allocatePointer(ID3D11VertexShader.class);
    	try {
    		int result = CreateVertexShader(compiledCode.GetBufferPointer(), (int) compiledCode.GetBufferSize(),
    										linkage != null ? pointerTo(linkage) : null,
    										pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create vertex shader", result);
    		}    		
    		
    		return pp.get().getNativeObject(ID3D11VertexShader.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}    	
    }
    
    public final ID3D11PixelShader CreatePixelShader(ID3D10Blob compiledCode, ID3D11ClassLinkage linkage) {
    	Pointer<Pointer<ID3D11PixelShader>> pp = allocatePointer(ID3D11PixelShader.class);
    	try {
    		int result = CreatePixelShader(compiledCode.GetBufferPointer(), (int) compiledCode.GetBufferSize(),
    										linkage != null ? pointerTo(linkage) : null,
    										pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create pixel shader", result);
    		}    		
    		
    		return pp.get().getNativeObject(ID3D11PixelShader.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    	
    }
    
    public final ID3D11GeometryShader CreateGeometryShader(ID3D10Blob compiledCode, ID3D11ClassLinkage linkage) {
    	Pointer<Pointer<ID3D11GeometryShader>> pp = allocatePointer(ID3D11GeometryShader.class);
    	try {
    		int result = CreateGeometryShader(compiledCode.GetBufferPointer(), (int) compiledCode.GetBufferSize(),
    										linkage != null ? pointerTo(linkage) : null,
    										pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create geometry shader", result);
    		}    		
    		
    		return pp.get().getNativeObject(ID3D11GeometryShader.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    	
    }
    
    public final ID3D11HullShader CreateHullShader(ID3D10Blob compiledCode, ID3D11ClassLinkage linkage) {
    	Pointer<Pointer<ID3D11HullShader>> pp = allocatePointer(ID3D11HullShader.class);
    	try {
    		int result = CreateHullShader(compiledCode.GetBufferPointer(), (int) compiledCode.GetBufferSize(),
    										linkage != null ? pointerTo(linkage) : null,
    										pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create hull shader", result);
    		}    		
    		
    		return pp.get().getNativeObject(ID3D11HullShader.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    	
    }
    
    public final ID3D11DomainShader CreateDomainShader(ID3D10Blob compiledCode, ID3D11ClassLinkage linkage) {
    	Pointer<Pointer<ID3D11DomainShader>> pp = allocatePointer(ID3D11DomainShader.class);
    	try {
    		int result = CreateDomainShader(compiledCode.GetBufferPointer(), (int) compiledCode.GetBufferSize(),
    										linkage != null ? pointerTo(linkage) : null,
    										pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create domain shader", result);
    		}    		
    		
    		return pp.get().getNativeObject(ID3D11DomainShader.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    	
    }
    
    public final ID3D11ComputeShader CreateComputeShader(ID3D10Blob compiledCode, ID3D11ClassLinkage linkage) {
    	Pointer<Pointer<ID3D11ComputeShader>> pp = allocatePointer(ID3D11ComputeShader.class);
    	try {
    		int result = CreateComputeShader(compiledCode.GetBufferPointer(), (int) compiledCode.GetBufferSize(),
    										linkage != null ? pointerTo(linkage) : null,
    										pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create compute shader", result);
    		}    		
    		
    		return pp.get().getNativeObject(ID3D11ComputeShader.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    	
    }
    
    public final ID3D11Buffer CreateBuffer(D3D11_BUFFER_DESC desc, D3D11_SUBRESOURCE_DATA initialData) {
    	Pointer<Pointer<ID3D11Buffer>> pp = allocatePointer(ID3D11Buffer.class);
    	try {
    		int result = CreateBuffer(pointerTo(desc), pointerTo(initialData), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create buffer", result);
    		} 
    		
    		return pp.get().getNativeObject(ID3D11Buffer.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}    	
    }
    public final ID3D11Texture1D CreateTexture1D(D3D11_TEXTURE1D_DESC desc, D3D11_SUBRESOURCE_DATA initialData) {
    	Pointer<Pointer<ID3D11Texture1D>> pp = allocatePointer(ID3D11Texture1D.class);
    	try {
    		int result = CreateTexture1D(pointerTo(desc), pointerTo(initialData), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create 1D texture", result);
    		} 
    		
    		return pp.get().getNativeObject(ID3D11Texture1D.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}    	
    }
    public final ID3D11Texture2D CreateTexture2D(D3D11_TEXTURE2D_DESC desc, D3D11_SUBRESOURCE_DATA initialData) {
    	Pointer<Pointer<ID3D11Texture2D>> pp = allocatePointer(ID3D11Texture2D.class);
    	try {
    		int result = this.CreateTexture2D(pointerTo(desc), pointerTo(initialData), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create 2D texture", result);
    		} 
    		
    		return pp.get().getNativeObject(ID3D11Texture2D.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}    	
    }
    public final ID3D11Texture3D CreateTexture3D(D3D11_TEXTURE3D_DESC desc, D3D11_SUBRESOURCE_DATA initialData) {
    	Pointer<Pointer<ID3D11Texture3D>> pp = allocatePointer(ID3D11Texture3D.class);
    	try {
    		int result = this.CreateTexture3D(pointerTo(desc), pointerTo(initialData), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create 3D texture", result);
    		} 
    		
    		return pp.get().getNativeObject(ID3D11Texture3D.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}    	
    }
    
    public final ID3D11BlendState CreateBlendState(D3D11_BLEND_DESC desc) {
    	Pointer<Pointer<ID3D11BlendState>> pp = allocatePointer(ID3D11BlendState.class);
    	try {
    		int result = this.CreateBlendState(pointerTo(desc), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create blend state", result);
    		}
    		
    		return pp.get().getNativeObject(ID3D11BlendState.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    }
    public final ID3D11DepthStencilState CreateDepthStencilState(D3D11_DEPTH_STENCIL_DESC desc) {
    	Pointer<Pointer<ID3D11DepthStencilState>> pp = allocatePointer(ID3D11DepthStencilState.class);
    	try {
    		int result = this.CreateDepthStencilState(pointerTo(desc), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create depth stencil state", result);
    		} 
    		
    		return pp.get().getNativeObject(ID3D11DepthStencilState.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    }
    public final ID3D11RasterizerState CreateRasterizerState(D3D11_RASTERIZER_DESC desc) {
    	Pointer<Pointer<ID3D11RasterizerState>> pp = allocatePointer(ID3D11RasterizerState.class);
    	try {
    		int result = this.CreateRasterizerState(pointerTo(desc), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create rasterizer state", result);
    		} 
    		
    		return pp.get().getNativeObject(ID3D11RasterizerState.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    }
    public final ID3D11SamplerState CreateSamplerState(D3D11_SAMPLER_DESC desc) {
    	Pointer<Pointer<ID3D11SamplerState>> pp = allocatePointer(ID3D11SamplerState.class);
    	try {
    		int result = this.CreateSamplerState(pointerTo(desc), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create sampler state", result);
    		}
    		
    		return pp.get().getNativeObject(ID3D11SamplerState.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    }
    
    public final ID3D11Query CreateQuery(D3D11_QUERY_DESC desc) {
    	Pointer<Pointer<ID3D11Query>> pp = allocatePointer(ID3D11Query.class);
    	try {
    		int result = this.CreateQuery(pointerTo(desc), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create query", result);
    		}
    		
    		return pp.get().getNativeObject(ID3D11Query.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    }
    
    public final ID3D11Predicate CreatePredicate(D3D11_QUERY_DESC desc) {
    	Pointer<Pointer<ID3D11Predicate>> pp = allocatePointer(ID3D11Predicate.class);
    	try {
    		int result = this.CreatePredicate(pointerTo(desc), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create predicate query", result);
    		}
    		
    		return pp.get().getNativeObject(ID3D11Predicate.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    }
    
    public final ID3D11Counter CreateCounter(D3D11_COUNTER_DESC desc) {
    	Pointer<Pointer<ID3D11Counter>> pp = allocatePointer(ID3D11Counter.class);
    	try {
    		int result = this.CreateCounter(pointerTo(desc), pp);
    		if(result != 0) {
    			throw new D3D11Exception("Could not create counter", result);
    		}
    		
    		return pp.get().getNativeObject(ID3D11Counter.class);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    }
    
    public final <R extends ID3D11Resource> R OpenSharedResource(HANDLE hResource, Class<R> type) {
    	Pointer<Byte> resourceGUID = COMRuntime.getIID(type);
    	Pointer<Pointer<R>> pp = allocatePointer(type);
    	try {
    		int result = this.OpenSharedResource(hResource, resourceGUID, pp);
    		if (result != 0) {
    			throw new D3D11Exception("Could not open shared resource", result);
    		}
    		
    		return pp.get().getNativeObject(type);
    	} finally {
    		pp.release();
   			pp = null;
    	}
    }
    
    public final int CheckFormatSupport(DXGI_FORMAT format) {
    	Pointer<Integer> pInt = allocateInt();
    	try {
    		int result = this.CheckFormatSupport(format, pInt);
    		if (result != 0) {
    			throw new D3D11Exception("Could not check format support", result);
    		}
    		return pInt.getInt();
    	} finally {
    		pInt.release();
    		pInt = null;
    	}
    }
    
    public final int CheckMultisampleQualityLevels(DXGI_FORMAT format, int SampleCount) {
    	Pointer<Integer> pInt = allocateInt();
    	try {
    		int result = this.CheckMultisampleQualityLevels(format, SampleCount, pInt);
    		if (result != 0) {
    			throw new D3D11Exception("Could not check format support", result);
    		}
    		return pInt.getInt();
    	} finally {
    		pInt.release();
    		pInt = null;
    	}
    }
}
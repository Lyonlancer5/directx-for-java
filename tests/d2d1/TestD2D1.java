package d2d1;


import static com.fourthskyinteractive.dx4j.d2d1.D2d1Library.D2D1CreateFactory;
import static com.fourthskyinteractive.dx4j.d2d1.D2d1Library.D2D1_FACTORY_TYPE.D2D1_FACTORY_TYPE_SINGLE_THREADED;
import static org.bridj.Pointer.NULL;
import static org.bridj.Pointer.allocate;
import static org.bridj.Pointer.allocateFloat;
import static org.bridj.Pointer.pointerToAddress;

import java.awt.Component;

import javax.swing.JFrame;

import org.bridj.Pointer;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.jawt.JAWT;
import org.bridj.jawt.JAWTUtils;
import org.bridj.jawt.JawtLibrary.JNIEnv;

import com.fourthskyinteractive.dx4j.d2d1.D2D1_BRUSH_PROPERTIES;
import com.fourthskyinteractive.dx4j.d2d1.D2D1_COLOR_F;
import com.fourthskyinteractive.dx4j.d2d1.D2D1_COLOR_F.ColorF;
import com.fourthskyinteractive.dx4j.d2d1.D2D1_HWND_RENDER_TARGET_PROPERTIES;
import com.fourthskyinteractive.dx4j.d2d1.D2D1_MATRIX_3X2_F;
import com.fourthskyinteractive.dx4j.d2d1.D2D1_RENDER_TARGET_PROPERTIES;
import com.fourthskyinteractive.dx4j.d2d1.D2D1_SIZE_U;
import com.fourthskyinteractive.dx4j.d2d1.ID2D1Factory;
import com.fourthskyinteractive.dx4j.d2d1.ID2D1HwndRenderTarget;
import com.fourthskyinteractive.dx4j.d2d1.ID2D1SolidColorBrush;


public class TestD2D1 {
	
	public static void main(String[] args) {
		COMRuntime.initialize();
		
		ID2D1Factory factory = D2D1CreateFactory(D2D1_FACTORY_TYPE_SINGLE_THREADED, null);
		Pointer<Float> pDpiX = allocateFloat();
		Pointer<Float> pDpiY = allocateFloat();
		
		factory.GetDesktopDpi(pDpiX, pDpiY);
		
		
		// Create JFrame
		JFrame frame = new JFrame("D2D Draw Rectangle");
		frame.setSize((int)Math.ceil(800.0f * pDpiX.getFloat() / 96.f), 
					  (int)Math.ceil(600.0f * pDpiY.getFloat() / 96.f));
		frame.setIgnoreRepaint(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		D2D1_SIZE_U size = new D2D1_SIZE_U().width(frame.getWidth()).height(frame.getHeight());
		D2D1_RENDER_TARGET_PROPERTIES rtProps = new D2D1_RENDER_TARGET_PROPERTIES()
															.dpiX(pDpiX.getFloat())
															.dpiY(pDpiY.getFloat());
		D2D1_HWND_RENDER_TARGET_PROPERTIES hwndProps = new D2D1_HWND_RENDER_TARGET_PROPERTIES()
														   .hwnd(pointerToAddress(JAWTUtils.getNativePeerHandle(frame)))
														   .pixelSize(size);
		final ID2D1HwndRenderTarget renderTarget = factory.CreateHwndRenderTarget(rtProps, hwndProps);
		D2D1_COLOR_F color = new D2D1_COLOR_F(ColorF.Azure);
		D2D1_BRUSH_PROPERTIES props = new D2D1_BRUSH_PROPERTIES();
		props.opacity(0.0f);
		props.transform()._11(1.f)._12(0.f)._21(0.f)._22(1.f)._31(0.f)._32(0.f);;
		final ID2D1SolidColorBrush grayBrush = renderTarget.CreateSolidColorBrush(new D2D1_COLOR_F(), new D2D1_BRUSH_PROPERTIES());
		//final ID2D1Brush cornflowerBlueBrush = renderTarget.CreateSolidColorBrush(new D2D1_COLOR_F(CornflowerBlue), null);
		
		final Pointer<D2D1_MATRIX_3X2_F> pMat = allocate(D2D1_MATRIX_3X2_F.class);
		
		JNIEnv env = JAWTUtils.getJNIEnv();
		JAWT jawt = JAWTUtils.getJAWT(env);
		while(frame.isEnabled()) {

			JAWTUtils.withLockedSurface(env, jawt, frame, new JAWTUtils.LockedComponentRunnable() {
				
				@Override
				public void run(Component comp, long peer) {
					renderTarget.BeginDraw();
					
					renderTarget.SetTransform(pMat);
					
					renderTarget.Clear(NULL);
					
					//D2D1_SIZE_F rtSize = renderTarget.GetSize();
					
					/*
					// Draw a grid background
					int width = (int) rtSize.width();
					int height = (int) rtSize.height();
					
					for(int x = 0; x < width; x+= 10) {
						renderTarget.DrawLine(new D2D1_POINT_2F(x, 0), 
											  new D2D1_POINT_2F(x, height), 
											  grayBrush, 
											  0.5f, 
											  null);
					}
					
					for(int y = 0; y < width; y+= 10) {
						renderTarget.DrawLine(new D2D1_POINT_2F(0, y), 
											  new D2D1_POINT_2F(width, y), 
											  grayBrush, 
											  0.5f, 
											  null);
					}
					
					*/
					
					renderTarget.EndDraw(NULL, NULL);
				}
			});
		}
		
		factory.Release();
	}

}

package d2d1;

/**
 * Created with IntelliJ IDEA.
 * User: evandro.paulino
 * Date: 18/06/13
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
import java.awt.Component;

import javax.swing.*;

import com.fourthskyinteractive.dx4j.d2d1.D2D1Exception;
import com.fourthskyinteractive.dx4j.d2d1.core.ID2D1Factory;
import com.fourthskyinteractive.dx4j.d2d1.resources.brush.D2D1_BRUSH_PROPERTIES;
import com.fourthskyinteractive.dx4j.d2d1.resources.brush.ID2D1Brush;
import com.fourthskyinteractive.dx4j.d2d1.resources.brush.ID2D1SolidColorBrush;
import com.fourthskyinteractive.dx4j.d2d1.resources.geometry.*;
import com.fourthskyinteractive.dx4j.d2d1.resources.rendertarget.D2D1_HWND_RENDER_TARGET_PROPERTIES;
import com.fourthskyinteractive.dx4j.d2d1.resources.rendertarget.D2D1_RENDER_TARGET_PROPERTIES;
import com.fourthskyinteractive.dx4j.d2d1.resources.rendertarget.ID2D1HwndRenderTarget;
import org.bridj.Pointer;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.jawt.JAWT;
import org.bridj.jawt.JAWTUtils;
import org.bridj.jawt.JawtLibrary.JNIEnv;

import static org.bridj.Pointer.*;

import static com.fourthskyinteractive.dx4j.d2d1.D2D1.*;
import static com.fourthskyinteractive.dx4j.d2d1.D2D1.ColorF.*;
import static com.fourthskyinteractive.dx4j.d2d1.D2D1.D2D1_FACTORY_TYPE.*;


public class TestD2D1 {

    public static void main(String[] args) throws D2D1Exception {
        COMRuntime.initialize();

        ID2D1Factory factory = D2D1CreateFactory(D2D1_FACTORY_TYPE_SINGLE_THREADED, null);
        Pointer<Float> pDpiX = allocateFloat();
        Pointer<Float> pDpiY = allocateFloat();

        factory.GetDesktopDpi(pDpiX, pDpiY);

        // Create JFrame
        final int frameWidth = (int)Math.ceil(800.0f * pDpiX.getFloat() / 96.f);
        final int frameHeight = (int)Math.ceil(600.0f * pDpiY.getFloat() / 96.f);

        JFrame frame = new JFrame("D2D Draw Rectangle");
        frame.setSize(frameWidth, frameHeight);
        frame.setIgnoreRepaint(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        props.transform()._11(1.f)._12(0.f)._21(0.f)._22(1.f)._31(0.f)._32(0.f);
        final ID2D1SolidColorBrush grayBrush = renderTarget.CreateSolidColorBrush(new D2D1_COLOR_F(), new D2D1_BRUSH_PROPERTIES());
        final ID2D1Brush cornflowerBlueBrush = renderTarget.CreateSolidColorBrush(new D2D1_COLOR_F(CornflowerBlue), null);

        final Pointer<D2D1_MATRIX_3X2_F> pMat = allocate(D2D1_MATRIX_3X2_F.class);

        JNIEnv env = JAWTUtils.getJNIEnv();
        JAWT jawt = JAWTUtils.getJAWT(env);
        while(frame.isEnabled()) {

            JAWTUtils.withLockedSurface(env, jawt, frame, new JAWTUtils.LockedComponentRunnable() {

                @SuppressWarnings("unchecked")
				@Override
                public void run(Component comp, long peer) {
                    renderTarget.BeginDraw();

                    renderTarget.SetTransform(pMat);

                    renderTarget.Clear(new D2D1_COLOR_F(Red));

                    //D2D1_SIZE_F rtSize = renderTarget.GetSize();

                    // Draw a grid background
                    int width = /*(int) rtSize.width()*/ frameWidth;
                    int height = /*(int) rtSize.height()*/ frameHeight;
                    /*
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
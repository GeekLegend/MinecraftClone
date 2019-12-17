package fr.geeklegend.minecraftclone.engine.rendering;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window
{
    private int width;
    private int height;
    private String title;
    private boolean isFullscreen;
    private boolean isResizable;
    private boolean isSync;

    public Window(int width, int height, String title)
    {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public Window(int width, int height, String title, boolean isFullscreen, boolean isResizable, boolean isSync)
    {
        this.width = width;
        this.height = height;
        this.title = title;
        this.isFullscreen = isFullscreen;
        this.isResizable = isResizable;
        this.isSync = isSync;
    }

    public void create() throws LWJGLException
    {
        Display.setDisplayMode(new DisplayMode(width, height));
        Display.setTitle(title);
        Display.setFullscreen(isFullscreen);
        Display.setResizable(isResizable);
        Display.setVSyncEnabled(isSync);
        Display.create();
    }

    public boolean isCloseRequested()
    {
        return Display.isCloseRequested();
    }

    public void update()
    {
        Display.update();
    }

    public void destroy()
    {
        Display.destroy();
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isFullscreen()
    {
        return isFullscreen;
    }

    public void setFullscreen(boolean fullscreen)
    {
        isFullscreen = fullscreen;
    }

    public boolean isResizable()
    {
        return isResizable;
    }

    public void setResizable(boolean resizable)
    {
        isResizable = resizable;
    }

    public boolean isSync()
    {
        return isSync;
    }

    public void setSync(boolean sync)
    {
        isSync = sync;
    }
}

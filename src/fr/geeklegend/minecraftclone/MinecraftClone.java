package fr.geeklegend.minecraftclone;

import fr.geeklegend.minecraftclone.engine.rendering.Window;
import org.lwjgl.LWJGLException;

import static org.lwjgl.opengl.GL11.*;

public class MinecraftClone
{

    public static MinecraftClone instance;
    private Window window;

    public MinecraftClone()
    {
        this.window = new Window(1280, 720, "MinecraftClone");
    }

    public void start() throws LWJGLException
    {
        instance = this;
        window.create();
        loop();
    }

    public void stop()
    {
        instance = null;
        window.destroy();
        System.exit(0);
    }

    private void loop()
    {
        long before = System.nanoTime();
        long timer = System.currentTimeMillis();

        double ns = 1000000000.0D / 60.0D;

        int ups = 0;
        int fps = 0;

        while (!window.isCloseRequested())
        {
            long now = System.nanoTime();

            if (now - before > ns)
            {
                before += ns;
                ups++;
                update();
            } else
            {
                fps++;
                render();
                window.update();
            }
            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                ups = 0;
                fps = 0;
            }
        }
        stop();
    }

    private void render()
    {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    private void update()
    {

    }

    public static void main(String[] args) throws LWJGLException
    {
        MinecraftClone minecraftClone = new MinecraftClone();
        minecraftClone.start();
    }

}

package nia.chapter2.echoserver;

import junit.framework.TestCase;
import org.junit.Test;

public class EchoServerTest extends TestCase {


    @Test
    public void startServer() throws Exception {
        int port = 9080;
        new EchoServer(port).start();
    }
}
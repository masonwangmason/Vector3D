import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import project01.Vector3D;

import java.util.Vector;

public class Vector3DTest {
    public Vector3D v1;
    public Vector3D v2;
    public Vector3D v3;

    // set up 3 Vector3D objects for following testings
    @BeforeEach
    public void setUp(){
        v1 = new Vector3D(1,2,3);
        v2 = new Vector3D(6,5,4);
        v3 = new Vector3D(7,7,7);
    }

    // test the get functions
    @Test
    public void testGet(){
        assertEquals(1, v1.getX());
        assertEquals(2, v1.getY());
        assertEquals(3, v1.getZ());
        assertEquals(4, v2.getZ());
        assertEquals(6, v2.getX());
        assertEquals(7, v3.getX());
    }

    // test the toString function
    @Test
    public void testToString(){
        assertEquals("(1.00, 2.00, 3.00)", v1.toString());
        assertEquals("(6.00, 5.00, 4.00)", v2.toString());
        assertEquals("(7.00, 7.00, 7.00)", v3.toString());
    }

    // test the getMagnitude function
    @Test
    public void testGetMagnitude(){
        assertEquals(4.0, (double) Math.round(v1.getMagnitude()));
        assertEquals(9.0, (double) Math.round(v2.getMagnitude()));
        assertEquals(12, (double) Math.round(v3.getMagnitude()));
    }

    // test the normalize function
    @Test
    public void testNormalize(){
        Vector3D v1n = v1.normalize();
        // modify the x value of v1n to avoid issues with floating point
        double v1n_x = Math.round(v1n.getX() * Math.pow(10, 2)) / Math.pow(10, 2);
        assertEquals(0.27, v1n_x);

        Vector3D v2n = v2.normalize();
        // modify the x value of v1n to avoid issues with floating point
        double v2n_y = Math.round(v2n.getY() * Math.pow(10, 2)) / Math.pow(10, 2);
        assertEquals(0.57, v2n_y);

        // test the IllegalStateException throw
        Vector3D v0 = new Vector3D(0,0,0);
        assertThrows(IllegalStateException.class, () -> v0.normalize());
    }

    // test the add function
    @Test
    public void testAdd(){
        Vector3D added_v = new Vector3D(1.00, 1.00, 1.00);
        Vector3D v1_new = v1.add(added_v);
        Vector3D v2_new = v2.add(added_v);
        Vector3D v3_new = v3.add(added_v);
        assertEquals(v1_new.getX(), 2.00);
        assertEquals(v2_new.getY(), 6.00);
        assertEquals(v3_new.getZ(), 8.00);
    }

    // test the multiply function
    @Test
    public void testMultiply(){
        Vector3D v1_multiplied = v1.multiply(2);
        assertEquals(2, v1_multiplied.getX());
        assertEquals(4, v1_multiplied.getY());
        assertEquals(6, v1_multiplied.getZ());
    }

    // test the dotProduct function
    @Test
    public void testDotProduct(){
        assertEquals(42.00, v1.dotProduct(v3));
        assertEquals(105.00, v2.dotProduct(v3));
        assertEquals(28.00, v1.dotProduct(v2));
    }

    // test the angleBetween function
    @Test
    public void testAngleBetween(){
        assertEquals(31.0, Math.round(v1.angleBetween(v2)));
        assertEquals(22.0, Math.round(v1.angleBetween(v3)));
        assertEquals(9.0, Math.round(v2.angleBetween(v3)));
        // test the IllegalStateException throw
        Vector3D v00 = new Vector3D(0,0,0);
        assertThrows(IllegalStateException.class, () -> Math.round(v1.angleBetween(v00)));
    }

    // test the crossProduct function
    @Test
    public void testCrossProduct(){
        Vector3D cp1 = v1.crossProduct(v2);
        assertEquals(-7.00, cp1.getX());
        assertEquals(14, cp1.getY());
        assertEquals(-7.00, cp1.getZ());

        Vector3D cp2 = v2.crossProduct(v3);
        assertEquals(7.00, cp2.getX());
        assertEquals(-14, cp2.getY());
        assertEquals(7.00, cp2.getZ());
    }
}

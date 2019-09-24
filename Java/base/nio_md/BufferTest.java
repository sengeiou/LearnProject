import java.nio.*;

/**



 */


public class BufferTest {

public static void main(String[] args){

        IntBuffer mIntBuffer = IntBuffer.allocate(12);

        mIntBuffer.put(1);



        System.out.println(String.format("the buffer capactiy is %s",mIntBuffer.capacity()));  //----> 12

        System.out.println(String.format("the buffer position is %s",mIntBuffer.position()));    //----> 1

        System.out.println(String.format("the buffer limit is %s",mIntBuffer.limit())); //----> 12


        mIntBuffer.put(2);
        mIntBuffer.put(3);
        mIntBuffer.put(4);

        // mIntBuffer.limit(mIntBuffer.position()).position(0);
        System.out.println(String.format("the buffer capactiy is %s",mIntBuffer.capacity()));  //----> 12

        System.out.println(String.format("the buffer position is %s",mIntBuffer.position()));    //----> 0

        System.out.println(String.format("the buffer limit is %s",mIntBuffer.limit())); //----> 4

      mIntBuffer.flip();
      mIntBuffer.flip();
      mIntBuffer.put(4);
       System.out.println(mIntBuffer.get());



}

}

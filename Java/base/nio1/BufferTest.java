import java.nio.*;




/**



*/


public class BufferTest{

    public static void main(String[] args){

        IntBuffer mIntBuffer = IntBuffer.allocate(12);

        mIntBuffer.put(1);


        System.out.println(String.format("the buffer capactiy is %s",mIntBuffer.capacity()));  //----> 12

        System.out.println(String.format("the buffer position is %s",mIntBuffer.position()));    //----> 1

        System.out.println(String.format("the buffer limit is %s",mIntBuffer.limit())); //----> 12
    }

}

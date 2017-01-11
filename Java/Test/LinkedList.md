*  链表是一种地柜的数据结构，它或者为空，或者是指向一个节点 ( Node ) 的引用，该节点含有一个泛型的元素 ( item ) 和一个指向另一个节点的引用（next）。

*  链表的遍历 for ( Node x = frist ; x != null ; x = x. next() )
* LinkedList 本身是用双向链表 ( 在普通链表的基础上多了一个指向上一节点的引用) 做为底层的存储, Node中的item为存储的元素, next 指向下一个Node节点，prev变量指向上一个节点

*   从时间复杂度看，LinkedList 的增加和删除会很快，只需要O(1)，但从空间复杂度看，LinkedList 比ArrrayList 占更多的空间

*  链表的缺点，无法通过下标定位节点

> 参考：
> [Java单链表、双端链表、有序链表实现](http://blog.csdn.net/a19881029/article/details/22695289)

```
//基于jdk_7u40-b43 
 public class LinkedList<E>
      extends AbstractSequentialList<E>
      implements List<E>, Deque<E>, Cloneable, java.io.Serializable
 {
      transient int size = 0;// linkedList的存储元素的数量

      transient Node<E> first;  // 链表的第一个元素

	  transient Node<E> last;   // 链表的最后的元素


114    // 构造方法
115     public LinkedList(Collection<? extends E> c) {
116         this();
117         addAll(c);
118     }

    
122     //在链表的最前面插入元素
123     private void linkFirst(E e) {
124         final Node<E> f = first;
125         final Node<E> newNode = new Node<>(null, e, f);
126         first = newNode;
127         if (f == null)// 链表中没有元素
128             last = newNode;
129         else       //链表中存在元素，插到最前面，first的前一个元素
130             f.prev = newNode;
131         size++;
132         modCount++;
133     }


137     //在链表的最后面插入元素
138     void linkLast(E e) {
139         final Node<E> l = last;
140         final Node<E> newNode = new Node<>(l, e, null);
141         last = newNode;
142         if (l == null)
143             first = newNode;
144         else
145             l.next = newNode;
146         size++;
147         modCount++;
148     }


152 	//插入元素到指定的节点前
153     void linkBefore(E e, Node<E> succ) {
154         // assert succ != null;
155         final Node<E> pred = succ.prev; // 前一个元素的复制
156         final Node<E> newNode = new Node<>(pred, e, succ);
157         succ.prev = newNode;           
158         if (pred == null)
159             first = newNode;
160         else
161             pred.next = newNode;
162         size++;
163         modCount++;
164     }

168     // 删除最前面元素，F就是first
169     private E unlinkFirst(Node<E> f) {
170         // assert f == first && f != null;
171         final E element = f.item;
172         final Node<E> next = f.next;
173         f.item = null;
174         f.next = null; // help GC
175         first = next;
176         if (next == null)
177             last = null;
178         else
179             next.prev = null;
180         size--;
181         modCount++;
182         return element;
183     }

    
187 // 删除最后面的元素，l就是last
188     private E unlinkLast(Node<E> l) {
189         // assert l == last && l != null;
190         final E element = l.item;
191         final Node<E> prev = l.prev;
192         l.item = null;
193         l.prev = null; // help GC
194         last = prev;
195         if (prev == null)
196             first = null;
197         else
198             prev.next = null;
199         size--;
200         modCount++;
201         return element;
202     }


206     // 删除某一个节点，并返回节点中的元素
207     E unlink(Node<E> x) {
208         // assert x != null;
209         final E element = x.item;
210         final Node<E> next = x.next;
211         final Node<E> prev = x.prev;
212 		//x前的节点的next指向x后的节点
213         if (prev == null) {
214             first = next;
215         } else {
216             prev.next = next;
217             x.prev = null;
218         }
219 		//x后的节点的prev指向x前的节点
220         if (next == null) {
221             last = prev;
222         } else {
223             next.prev = prev;
224             x.next = null;
225         }
226 
227         x.item = null;
228         size--;
229         modCount++;
230         return element;
231     }

238 	//获取第一个节点中的元素	
239     public E getFirst() {
240         final Node<E> f = first;
241         if (f == null)
242             throw new NoSuchElementException();
243         return f.item;
244     }


251     //获取最后的节点中的元素
252     public E getLast() {
253         final Node<E> l = last;
254         if (l == null)
255             throw new NoSuchElementException();
256         return l.item;
257     }

    

264     //移除第一个节点，调用了unlinkFirst
265     public E removeFirst() {
266         final Node<E> f = first;
267         if (f == null)
268             throw new NoSuchElementException();
269         return unlinkFirst(f);
270     }

    
277     //移除最后的节点
278     public E removeLast() {
279         final Node<E> l = last;
280         if (l == null)
281             throw new NoSuchElementException();
282         return unlinkLast(l);
283     }

    

289     //在链表的最前面增加一个节点
290     public void addFirst(E e) {
291         linkFirst(e);
292     }


300    //在链表的最后增加节点
301     public void addLast(E e) {
302         linkLast(e);
303     }


322    // 返回链表节点数，也就是长度
323     public int size() {
324         return size;
325     }



334     //向链表中增加一个节点，这个方法等价于 addLast(E e)
335     public boolean add(E e) {
336         linkLast(e);
337         return true;
338     }

// 删除包干指定元素的节点，里面主要是遍历了链表
// 从代码中也可以看出，LinkedList也是可以存放null元素的
// 如果链表中有多个相同的元素，调用次方法删除，只会删除一个 
353     public boolean remove(Object o) {
354         if (o == null) {
// 双向链表的遍历
355             for (Node<E> x = first; x != null; x = x.next) {
356                 if (x.item == null) {
357                     unlink(x);
358                     return true;
359                 }
360             }
361         } else {
362             for (Node<E> x = first; x != null; x = x.next) {
363                 if (o.equals(x.item)) {
364                     unlink(x);
365                     return true;
366                 }
367             }
368         }
369         return false;
370     }

383 
384     public boolean addAll(Collection<? extends E> c) {
385         return addAll(size, c);
386     }


402 	//	index 就是指定在哪个位置前插入
		//  c   就是要插入的集合，注意泛型
403     public boolean addAll(int index, Collection<? extends E> c) {
404         checkPositionIndex(index);
405 
406         Object[] a = c.toArray();
407         int numNew = a.length;
408         if (numNew == 0)
409             return false;
410 
411         Node<E> pred, succ;
412         if (index == size) {//在最后插入,last就成为第一个要插入节点的prev
413             succ = null;
414             pred = last;
415         } else { //找到某一个节点，找到他的前一个节点
416             succ = node(index);
417             pred = succ.prev;
418         }
419 
420         for (Object o : a) {
421             @SuppressWarnings("unchecked") E e = (E) o;
422             Node<E> newNode = new Node<>(pred, e, null);
423             if (pred == null)
424                 first = newNode;
425             else
426                 pred.next = newNode;
427             pred = newNode; //下一个节点的prev
428         }
429 
430         if (succ == null) { //在最后插入的
431             last = pred;
432         } else {    //在某一个位置插入的
433             pred.next = succ;
434             succ.prev = pred;
435         }
436 
437         size += numNew;
438         modCount++;
439         return true;
440     }


445     //清除链表，遍历链表，把所有节点中的元素都赋值为null，size置为0
446     public void clear() {
447         // Clearing all of the links between nodes is "unnecessary", but:
448         // - helps a generational GC if the discarded nodes inhabit
449         //   more than one generation
450         // - is sure to free memory even if there is a reachable Iterator
451         for (Node<E> x = first; x != null; ) {
452             Node<E> next = x.next;
453             x.item = null;
454             x.next = null;
455             x.prev = null;
456             x = next;
457         }
458         first = last = null;
459         size = 0;
460         modCount++;
461     }
462 
463 
464     // Positional Access Operations
465 
    

472 	//获取某一个位置的元素	
473     public E get(int index) {
474         checkElementIndex(index);
475         return node(index).item;
476     }



486    //修改某个位置的元素，并返回老的元素的值
487     public E set(int index, E element) {
488         checkElementIndex(index);
489         Node<E> x = node(index);
490         E oldVal = x.item;
491         x.item = element;
492         return oldVal;
493     }



503     //在某个位置插入元素
504     public void add(int index, E element) {
505         checkPositionIndex(index);
506 
507         if (index == size)
508             linkLast(element);
509         else
510             linkBefore(element, node(index));
511     }


521     //删除某一位置的节点 
522     public E remove(int index) {
523         checkElementIndex(index);
524         return unlink(node(index));
525     }


563    // 根据index 找到节点
564     Node<E> node(int index) {
565         // assert isElementIndex(index);
566 		
567         if (index < (size >> 1)) {
568             Node<E> x = first;
569             for (int i = 0; i < index; i++)
570                 x = x.next;
571             return x;
572         } else {
573             Node<E> x = last;
574             for (int i = size - 1; i > index; i--)
575                 x = x.prev;
576             return x;
577         }
578     }
579 
580     // Search Operations
581 



592   // 查找某一元素所在的位置
593     public int indexOf(Object o) {
594         int index = 0;
595         if (o == null) {
596             for (Node<E> x = first; x != null; x = x.next) {
597                 if (x.item == null)
598                     return index;
599                 index++;
600             }
601         } else {
602             for (Node<E> x = first; x != null; x = x.next) {
603                 if (o.equals(x.item))
604                     return index;
605                 index++;
606             }
607         }
608         return -1;
609     }


621    //某一元素在链表中最后出现的位置，其实就是用Node的prev从后向前遍历
	// 没有则返回-1
622     public int More ...lastIndexOf(Object o) {
623         int index = size;
624         if (o == null) {
625             for (Node<E> x = last; x != null; x = x.prev) {
626                 index--;
627                 if (x.item == null)
628                     return index;
629             }
630         } else {
631             for (Node<E> x = last; x != null; x = x.prev) {
632                 index--;
633                 if (o.equals(x.item))
634                     return index;
635             }
636         }
637         return -1;
638     }
639 
640     // Queue operations.
641 

647     //实现Deque的方法，返回最前面的元素
648     public E peek() {
649         final Node<E> f = first;
650         return (f == null) ? null : f.item;
651     }



659     // 返回最前面的节点中的元素
660     public E element() {
661         return getFirst();
662     }



```
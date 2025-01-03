package com.hlj.util.Z014Collection;

import com.hlj.util.Arraylist.Person;
import com.hlj.util.Z014Collection.data.SortEntry;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;



public class D01ArraylistTest {


	/**
	 * 1、测试remove方法 remove(object 或者是 index(int))
	 */
	@Test
	public void RemoveObjectMethod() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("String one");
		stringList.add("String one");
		stringList.add("String two");

		stringList.remove("String one"); //只能移除第一个重复元素
		System.out.println(stringList.size()); //2
		System.out.println(stringList); //[String one, String two]

		// 2
		// [String one, String two]
	}
	@Test
	public  void RemoveIndexMethod() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("String one");
		stringList.add("String two");
		stringList.add("String three");
		stringList.remove(0);
		System.out.println(stringList); //[String two, String three]


		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(10000);
		integerList.remove(0);
		System.out.println(integerList); //[2, 10000]

		integerList.remove((Integer)2);
		System.out.println(integerList); //[10000]

		integerList.remove((Integer)10000);
		System.out.println(integerList); //[]

		// [String two, String three]
		// [2, 10000]
		// [10000]
		// []
	}


    /**
     * 2、设定arraylist最大的size 毫无意义
     * ArrayList中没有值时，则size为0
     * 不管size初始化为几 其实是没有意义的，只会动态的的得到它的大小
     */
	@Test
    public  void NewArraylist(){

    	List<String> strs = new ArrayList<String>(2);
    	//里面没有值 自然之类得到的 大小为 0
    	System.out.println(strs.size()); //0

    	strs.add("第一个size");
    	strs.add("第二个size");
    	strs.add("第三个size");
    	strs.add("第四个size");
    	System.out.println(strs.size()); //4

    }



	/**
	 * 3、 list 放入有顺序
	 */
	@Test
	public void listHaveAddSort(){
		List<Person> persons= new ArrayList<Person>();
		Person person = new Person(0, "HealerJean");
		Person person2 = new Person(0, "HealerJean");
		persons.add(0,person);
		persons.add(3,person2); //报错，因为没有 2
	}



	/**
	 4、list 去重
	 */
	@Test
	public void deleteSim(){

		deleteSimSet();

		delteSimIfContain();

		delteSimAddAllSet();
	}

	/**
	 set集合去重，不打乱顺序
	 */
	public void deleteSimSet(){

		System.out.println("1、set集合去重，不打乱顺序");
		 List<String> list  =   new  ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.add("aba");
        list.add("aaa");

        Set set = new  HashSet();
        List newList = new  ArrayList();
        for (String cd:list) {
           if(set.add(cd)){
               newList.add(cd);
           }
       }
        System.out.println( "去重后的集合： " + newList);
	}

	 /**
	   遍历后判断赋给另一个list集合
	 */
	public void delteSimIfContain(){
      System.out.println("2、遍历后判断赋给另一个list集合");
      List<String> list  =   new  ArrayList<String>();
      list.add("aaa");
      list.add("bbb");
      list.add("aaa");
      list.add("aba");
      list.add("aaa");

      List<String> newList = new  ArrayList<String>();
      for (String cd:list) {
         if(!newList.contains(cd)){
             newList.add(cd);
         }
     }
      System.out.println( "去重后的集合： " + newList);
	}

	/**
	 * set.addAll();
	 * list.add(Set)
	 */
	public void delteSimAddAllSet(){
	      System.out.println("2、遍历后判断赋给另一个list集合");

		  List<String> list  =   new  ArrayList<String>();
	         list.add("aaa");
	         list.add("bbb");
	         list.add("aaa");
	         list.add("aba");
	         list.add("aaa");

	        Set set = new  HashSet();
	         List newList = new  ArrayList();
	         set.addAll(list);
	         newList.addAll(set);

	         System.out.println( "去重后的集合： " + newList);
	}




	/**
	 *
	 5、清除list集合 list.clear();
	 */
	@Test
	public void clear(){
	      List<String> list  =   new  ArrayList<String>();
	      list.add("aaa");
	      list.add("bbb");
	      list.add("aaa");
	      list.add("aba");
	      list.add("aaa");

	      list.clear();

	      System.out.println( "list.clear list大小 " + list.size());
		}

	/**
	 * 6、list 并集addAll，交集retainAll，差集removeAll
	 */
	@Test
	public void retainAllAndremoveAll() {

		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list1 = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);

		list1.add(2);
		list1.add(3);
		list1.add(4);

		//list和list1的并集：
		//	list.addAll(list1); //1 2 3 2 3 4

		//list和list1的交集：
		//	list.retainAll(list1); // 2 3
		//list和list1的差集：
		list.removeAll(list1);  //1

		for (Integer integer : list) {
			System.out.println(integer);
		}

	}

	/**
	 * 7、list set方法根据索引插入并且替换数据
	 */

	@Test
	public void setInsert(){
		String a="A",b="B",c="C",d="D",e="E";
		List<String>list=new ArrayList<>();
		list.add(a);
		list.add(e);
		list.add(d);
		Iterator<String>first=list.iterator();
		System.out.printf("修改前集合中的元素是：");
		while(first.hasNext()){
			System.out.print(first.next()+"    ");
		}

		System.out.println();
	    String temp=	list.set(1, b); //直接替换了上面的索引为1的元素2,并将原来位置上的数据返回
		System.out.println("替换后的元素是"+b+"被替换的是"+temp); //E
		System.out.printf("set修改集合后的元素是：");
		System.out.println(list);


		list.add(2,c);//在索引为2的位置插入了元素c，然后向后移动一位
		System.out.printf("修改集合后的元素是：");
		System.out.println(list);

		// 修改前集合中的元素是：A    E    D
		// 替换后的元素是B被替换的是E
		// set修改集合后的元素是：[A, B, D]
		// 修改集合后的元素是：[A, B, C, D]


	}


	/**
	 * 8、list 数组、逗号字符串中间的转换
	 */
	@Test
	public void cover(){

		String array[] = {"1","2","3"};
		List<String> list ;
		String str ;
		//1、数组 ->>>>> 集合
		list =  Arrays.stream(array).collect(Collectors.toList());
		list =  Arrays.asList(array);

		//2、集合 ->>>>> 数组
		array =  list.toArray(new String[0]);



		// 3、集合 ->>>>> 字符串
		str = String.join(",", list); //建议
		str = StringUtils.join(list,"," ); //建议
		str = list.stream().collect(Collectors.joining(",")); // 不建议

		// 4、字符串  ->>>>>  集合
		list = Arrays.asList(str.split(",")) ;


		// 5、 数组  ->>>>>  字符串
		str = String.join(",", array); //建议
		str = StringUtils.join(array,"," ); //建议
		str = Arrays.stream(array).collect(Collectors.joining(",")); // 不建议

		// 6、字符串  ->>>>>  数组
		array = str.split(",");



		// 7、字符串转 int数组
		int[] nums = Arrays.stream(array).mapToInt(Integer::new).toArray();
		nums = Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
		// 8、int数 转 String集合
		list = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());

	}





	/**
	 *  9.1、 list 排序 ：逆序 降序 增序
	 */
	@Test
	public void CollectionsReverse(){

		List<Long> ids  = new ArrayList<>();
		ids.add(1L);
		ids.add(3L);
		ids.add(4L);
		ids.add(8L);
		ids.add(5L);
		ids.add(10L);
		ids.add(10L);
		ids.add(19L);
		ids.add(18L);
		ids.add(14L);
		ids.add(12L);


		//逆序  [12, 14, 18, 19, 10, 10, 5, 8, 4, 3, 1]
		Collections.reverse(ids);
		System.out.println("逆序   "+ids);

		//默认升序 [1, 3, 4, 5, 8, 10, 10, 12, 14, 18, 19]
		Collections.sort(ids);
		System.out.println("默认升序"+ids);

		//降序Collections.reverseOrder() [19, 18, 14, 12, 10, 10, 8, 5, 4, 3, 1]
		Collections.sort(ids, Collections.reverseOrder());
		System.out.println("降序   "+ids);

	}




	/**
	 *  9.2、 list 排序 ：先按照年龄数排序，如果年龄相等了再用分数进行排序
	 *
	 */
	@Test
	public void listObjectSort(){

		List<SortEntry> sortEntries = new ArrayList<SortEntry>();
		sortEntries.add(new SortEntry(23, 100));
		sortEntries.add(new SortEntry(27, 98));
		sortEntries.add(new SortEntry(29, 99));
		sortEntries.add(new SortEntry(29, 98));
		sortEntries.add(new SortEntry(22, 89));
		Collections.sort(sortEntries, (o1, o2) -> {
			int i = o1.getScore() - o2.getScore();  //先按照分数排序
			if(i == 0){
				return o1.getAge() - o2.getAge();  //如果年龄相等了再用分数进行排序
			}
			return i;
		});

		System.out.println(sortEntries);

	}


	/**
	 * 10、list截取长度 index包头不包尾巴
	 */
	@Test
	public void listSub(){
		List<Long> list = new ArrayList<>();
		list.add(1L) ;
		list.add(2L) ;
		list.add(3L) ;
		list.add(4L) ;

		List<Long> finalList = list.subList(1, 3);
		System.out.println(finalList); //[2, 3]

	}

	/**
	 * 11、泛型
	 * Java中的泛型，只在编译阶段有效，Java中编译后的class不会包含泛型信息
	 *  反射：       所有反射的操作都是在运行时的，运行时表示已经经过编译了
	 * 	 * 既然为true，就证明了编译之后， 程序会采取去泛型化的措施，也就是说
	 * 	 * 成功编译过后的class文件中是不包含任何泛型信息的。泛型信息不会进入到运行时阶段。
	 */
	@Test
	public void t(){
		//1、可以打印
		List list = new ArrayList();
		list.add(1);
		list.add("String");
		Iterator iterator = list.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());//正常打印
		}

		//2、 Java中的泛型，只在编译阶段有效，Java中编译后的class不会包含泛型信息
		ArrayList<String> lista = new ArrayList<>();
		ArrayList listb = new ArrayList();
		Class c1 = lista.getClass();
		Class c2 = listb.getClass();

		System.out.println(lista == listb); //false
		System.out.println(c1 == c2); //true   表示已经经过编译了


		//3、反射调用arrylist，说明泛型只在编译阶段有效
		ArrayList<String> a = new ArrayList<>();
		a.add("CSDN_SEU_Cavin");
		Class c = a.getClass();
		try{
			Method method = c.getMethod("add",Object.class);
			method.invoke(a,100);
			System.out.println(a);  //[CSDN_SEU_Cavin, 100]
		}catch(Exception e){
			e.printStackTrace();
		}

	}


	/**
	 * 12、foreach中断
	 */
	@Test
	public void method(){
		List<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);

		list.stream().forEach(item ->{
			// 不可以放入 break;continue ; return相当于continue
			if (item == 2){
				return;
			}
			System.out.println(item);
		});


		// 1
		// 3
	}



	/**
	 * 14、new ArrayList
	 */
	@Test
	public void arrayListTest(){

		Stack<String> stack = new Stack<>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		List<String> list1 = new ArrayList(stack);
		System.out.println(list1);

		/** Map<String, List<String>> map  */
		Map<String, List<String>> map = new HashMap<>();
		List<String> lista = new ArrayList<>();
		lista.add("a");
		lista.add("b");
		lista.add("c");
		map.put("keyA", lista);
		List<String> listb = new ArrayList<>();
		listb.add("a");
		listb.add("b");
		listb.add("c");
		map.put("keyB", listb);
		List<List<String>> list2 = new ArrayList<>(map.values());
		System.out.println(list2);

	}






}

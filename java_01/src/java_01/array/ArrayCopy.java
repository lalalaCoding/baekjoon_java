package java_01.array;

import java.util.Arrays;

public class ArrayCopy {
	public void arrayCopy() {
		
		int[] originArr = {1, 2, 3, 4, 5};
		int[] copyArr = new int[10];
		
		// 깊은 복사
		copyArr = Arrays.copyOf(originArr, originArr.length);
		System.out.println(Arrays.toString(copyArr));
		
		// 얕은 복사
		System.arraycopy(originArr, 0, copyArr, 3, originArr.length);
		System.out.println(Arrays.toString(copyArr));
	}
}

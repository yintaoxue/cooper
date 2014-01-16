package org.ruogu.cooper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.ruogu.cooper.model.Entity;

public class Sort {

	public void sort(List<Entity> dataList) {
		if (dataList == null) {
			return;
		}
		// 升序排列
		Collections.sort(dataList, new Comparator<Entity>() {
			public int compare(Entity e1, Entity e2) {
				int s1 = e1.getInteger("score");
				int s2 = e2.getInteger("score");
				
				if (s1 > s2) {
					return 1;
				} else if (s1 == s2) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		// 降序排列
		Collections.reverse(dataList);
	}

}

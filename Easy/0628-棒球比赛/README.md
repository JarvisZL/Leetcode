# solution

用List存储每轮的分数

+ 数字：list.add(num); sum += num;
+ "+":     now = list.get(list.size() - 1) + list.get(list.size()  - 2); list.add(now); sum += now;
+ "C":     sum -= list.get(list.size() - 1); list.remove(list.size() - 1);
+ "D":     now = list.get(list.size() - 1) * 2; list.add(now); sum += now;
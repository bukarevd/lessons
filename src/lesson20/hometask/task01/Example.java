//package lesson20.hometask.task01;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CreateMap {
//    public static void main(String[] args) throws InterruptedException {
//        int[] ints = new int[13];
//        int count = 0;
//        Resource resource = new Resource();
//        resource.setLeight(ints.length, count);
//        List<Threads> threadList = new ArrayList<>();
//        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
//            threadList.add(new Threads());
//        }
//        for (Threads thread : threadList) {
//            thread.setResource(resource);
//            thread.start();
//            thread.join();
//        }
//    }
//}
//
//class Threads extends Thread {
//    Resource resource;
//    int processor = Runtime.getRuntime().availableProcessors();
//
//    public void setResource(Resource resource) {
//        this.resource = resource;
//    }
//
//    int leight;
//    int count;
//    int start;
//    int end;
//
//    @Override
//    public synchronized void run() {
//        leight = resource.getLeight();
//        count = resource.getCount();
//        start = resource.getStart();
//        end = resource.getEnd();
//        if (leight % processor == 0) {
//            if (count == 0 && count < processor) {
//                start = 0;
//                end = leight / processor - 1;
//                count++;
//            } else {
//                start = start + (leight / processor);
//                if (count == processor - 1)
//                    end = start + (leight - start) - 1;
//                else
//                    end = start + (leight / processor) - 1;
//                count++;
//            }
//        } else {
//            if (count == 0 && count < processor) {
//                start = 0;
//                end = leight / processor;
//                count++;
//            } else {
//                start = start + (leight / processor) + 1;
//                if (count == processor - 1)
//                    end = start + (leight - start) - 1;
//                else
//                    end = start + (leight / processor);
//                count++;
//            }
//        }
//        resource.setLeight(leight, count);
//        resource.setStart(start);
//        resource.setEnd(end);
//        resource.setCount(count);
//        System.out.println(resource.getLeight() + " " + resource.getStart() + " " + resource.getEnd());
//    }
//}
//
//class Resource {
//    private int leight;
//    int count;
//    int start;
//    int end;
//
//    public int getLeight() {
//        return leight;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setStart(int start) {
//        this.start = start;
//    }
//
//    public int getStart() {
//        return start;
//    }
//
//    public int getEnd() {
//        return end;
//    }
//
//    public void setEnd(int end) {
//        this.end = end;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public void setLeight(int leight, int count) {
//        this.leight = leight;
//        this.count = count;
//    }
//}

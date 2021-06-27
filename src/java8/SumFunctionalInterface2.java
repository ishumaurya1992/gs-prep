package java8;

@FunctionalInterface
interface SumFunctionalInterface2 {
      default int sum(int a, int b){
          return a+b;
      };
      int sum(float a,int b);
}

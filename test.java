interface FirstExample {
    void show();
}
class test{
    public static void main(String[] args) {
      FirstExample obj = new FirstExample()
      {
        public void show() {
            System.out.println("new implementation");
        }
      };
      obj.show();
   }
}
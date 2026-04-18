import processing.core.*;

public class Node{
 
  public static PApplet processing; 
  public static int nodeCount = 0;
  public static char[] path = {' ', ' ', ' ', ' ', ' ', ' '};
  public static int currentPathIndex = 0;
  public static char destination = ' ';
  
  
  Node parent;
  float xPos, yPos;
  
  int depth = 0;
  int valueIndex;
  char value;
  int treeIndex;
  int dir = 0;
  boolean active = false;
  
  
  Node left = null;
  Node right = null; 
  
 
  Node(Node p, char v, int vi, int d){
    
        this.parent = p;
    this.value = v;
    this.valueIndex = vi;
    this.nodeCount++;
    this.treeIndex = this.nodeCount;
    this.dir = d;
    
    if (this.parent != null){
      this.depth = this.parent.depth + 1;
       
            float factor = this.processing.pow(2, depth+1);
      float dist = this.processing.width / factor;
      this.xPos = this.parent.xPos + (dist * d);
      
    }else{
      this.xPos = this.processing.width / 2;
    }
    
    this.yPos = 80 + (this.depth * 80);
  }

  public void interpret(){
    
    this.active = true;
    this.destination = this.value;
    
    if (this.path[this.depth] == '.' && this.left != null) {
      this.left.interpret();
    }
      
    if (this.path[this.depth] == '-' && this.right != null) 
      this.right.interpret();
      
  }
  
  public static void insert(char c){
    
    if (currentPathIndex > path.length) clearPath();
    path[currentPathIndex] = c;
    currentPathIndex++;
    
  }

  void addNode(char v, int vi){
        if (vi < this.valueIndex){

            if (this.left == null){
        this.left  = new Node(this, v, vi, -1);            }else{
          this.left.addNode(v, vi);              }
      }else{
      
            if (this.right == null){
        this.right  = new Node(this, v, vi, 1);         }else{
        this.right.addNode(v, vi);          }
    }  
  }

    void draw(){
 
    if (this.value != '-'){
      
      this.processing.stroke(255, 120);
            if (this.parent != null)
        this.processing.line(this.xPos, this.yPos, this.parent.xPos, this.parent.yPos);
        
      this.processing.noStroke();
      this.processing.fill(255);
      this.processing.text(this.value, this.xPos - 3, yPos - 20);
      this.processing.ellipse(this.xPos, 80 + (this.depth * 80), 10, 10);
      
      if (this.active){
        this.processing.fill(255, 0, 0, 100);
        this.processing.ellipse(this.xPos, 80 + (this.depth * 80), 18, 18);
      }
      
            if (this.left != null) this.left.draw();
      if (this.right != null) this.right.draw();
    }
  }
  
  public static void clearPath(){
    for(int i = 0; i < path.length; i++){
      path[i] = ' ';
    }
  }
  
    public static void setProcessing(PApplet p){
    processing = p;
  }
  
  public static char getDestination(){
    return destination;
  }
}
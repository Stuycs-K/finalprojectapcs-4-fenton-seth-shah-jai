import controlP5.*;

ControlP5 cp5;
run NAT;
int background=color(255,255,255);

void setup(){
  size(800,400);
  cp5=new ControlP5(this);
  cp5.addButton("NextTurn")
    .setPosition(50,50)
    .setSize(100,100)
    .setLabel("Turn End");
  NAT=new run();
  //I need nothing ever happens as an image
  //radio button as my event. Super events?
  //
  //
}

void NextTurn(){
    NAT.turn();
}

import controlP5.*;

ControlP5 cp5;
run NAT;
Textlabel eventNew;
int background=color(255,255,255);

void setup(){
  size(800,400);
  cp5=new ControlP5(this);
  cp5.addButton("NextTurn")
    .setPosition(50,50)
    .setSize(100,100)
    .setLabel("Turn End");
  eventNew=cp5.addTextlabel("EventNew")
    .setText("Awaiting something")
    .setPosition(400,400)
    .hide();
  NAT=new run();
  //I need nothing ever happens as an image
  //radio button as my event. Super events?
  //
  //
}

void NextTurn(){
    NAT.turn();
    eventNew.setText("Guys, "+Events.getCurrent()).show();
    delay(1000);
    eventNew.hide();
    
}

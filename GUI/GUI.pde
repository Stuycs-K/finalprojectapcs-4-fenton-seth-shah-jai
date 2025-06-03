import controlP5.*;

ControlP5 cp5;
run NAT;
Textlabel eventNew;
float interestRate;
float taxBracket;
int background=color(255,255,255);

void draw(){
  text(run.ProcessCondition(), 300, 200);
}

void setup(){
  size(1200,800);
  cp5=new ControlP5(this);
  cp5.addButton("NextTurn")
    .setPosition(700,400)
    .setSize(300,300)
    .setLabel("Turn End");
  eventNew=cp5.addTextlabel("EventNew")
    .setText("Awaiting something")
    .setPosition(400,400)
    .hide();
  cp5.addNumberbox("MaxTaxBracket")
    //.setPosition()
    .setSize(200,60)
    .setRange(0.0,1.0)
    //.setValue();
    .setLabel("Max Tax Bracket");
  cp5.addNumberbox("InterestRate")
    //.setPosition()
    .setSize(200,60)
    .setRange(0.0,1.0)
    //.setValue();
    .setLabel("Interest Rate");
  cp5.addNumberbox("MAN")
    //.setPosition()
    .setSize(200,60)
    //.setRange()
    //.setValue();
    .setLabel("Manufacturing");
  cp5.addNumberbox("WEL")
    //.setPosition()
    .setSize(200,60)
    //.setRange()
    //.setValue();
    .setLabel("Welfare");
  cp5.addNumberbox("HEL")
    //.setPosition()
    .setSize(200,60)
    //.setRange()
    //.setValue();
    .setLabel("Healthcare");
  cp5.addNumberbox("SAL")
    //.setPosition()
    .setSize(200,60)
    //.setRange()
    //.setValue();
    .setLabel("Saleries");  
  cp5.addNumberbox("MIL")
    //.setPosition()
    .setSize(200,60)
    //.setRange()
    //.setValue();
    .setLabel("Military");
  cp5.addNumberbox("OTH")
    //.setPosition()
    .setSize(200,60)
    //.setRange()
    //.setValue();
    .setLabel("Other");
    
    //Do this for all of them

  
    
  NAT=new run();
  //I need nothing ever happens as an image
  //radio button as my event. Super events?
  //
  //
}

void NextTurn(){
    NAT.turn();
    eventNew.setText("Guys, "+Events.getCurrent()).show();
    delay(4000);
    eventNew.hide();
    
}

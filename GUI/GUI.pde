import controlP5.*;

ControlP5 cp5;
run NAT;
Textarea eventNew;
float interestRate;
float taxBracket;
double[] newBudget=new double[6];
int background=color(140,140,140);
int times=0;
int showSwitch=0;
PImage Hap;
PImage Sad;
PImage opening, closing;
int currentImage=0;

void draw(){
  if(currentImage==0){
    background(0);
    image(opening, 0,0, width,height);
    textSize(40);
    text("Welcome to Economy Simulator",0,40);
  }
  else if(currentImage==1){
  background(loadImage("istockphoto-175600020-612x612.jpg"));
  fill(255, 0, 255);
  rect(0, 100, 300, 250);
  fill(0);
  textSize(12);
  text(NAT.ProcessCondition(), 0, 120);
  if(eventNew.isVisible()&&millis()-times>3000){
    eventNew.hide();
    showSwitch=0;
  }
  if(showSwitch==1){
    image(Hap, 300, 300, 200,100);
  }
  if(showSwitch==2){
    image(Sad, 300, 300, 200,100);
  }
  }
  else if(currentImage==2){
    background(0);
    textSize(24);
    fill(255);
    image(closing, 0,0, width,height);
    text("Game Over, you've been kicked out for gross incompetence",0,20);
  }
}
void setup(){

  PImage image = loadImage("istockphoto-175600020-612x612.jpg");
  opening=loadImage("Opening.jpg");
  closing=loadImage("Lose.jpg");
  background(image);
    size(612,407);
      fill(255, 0, 255);
    rect(0,20, 550, 30);
    fill(0);
      String[] eventText = loadStrings("Events.txt");
  
      Events.eventMaker(eventText);
  Hap=loadImage("SomethingH.png");
  Sad=loadImage("NothingE.jpg");
  cp5=new ControlP5(this);
    NAT=new run();
  NAT.initializeNation ("Default",100,100,100,100,100,100,100,100,100,100,new double[]{100, 100, 100, 100, 100, 100},100,100,100,100, 100);

  cp5.addButton("NextTurn")
    .setPosition(500,200)
    .setSize(100,100)
    .setLabel("Turn End");
  eventNew=cp5.addTextarea("EventNew")
    .setText("Awaiting something")
    .setPosition(300,300)
    .setColor(160)
    .setColorBackground(color(255,255,255,0))
    .setSize(200,100)
    .hide();
  cp5.addTextfield("MaxTaxBracket")
    .setPosition(0,0)
    .setSize(70,30)
    //.setRange(0.0,1.0)
    .setText(str((float) NAT.getNation().getMaxTaxBracket()))
    .setLabel("Max Tax Bracket");
  cp5.addTextfield("InterestRate") 
    .setPosition(70,0)
    .setSize(70,30)
    //.setRange(0.0, 3)
    .setText(str((float) NAT.getNation().getInterestRate()))
    .setLabel("Interest Rate")
  ;

  cp5.addTextfield("MAN")
    .setPosition(140,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[0]))
    .setLabel("Manufacturing");
  cp5.addTextfield("WEL")
    .setPosition(210,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[1]))
    .setLabel("Welfare");
  cp5.addTextfield("HEL")
  .setPosition(280,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[2]))
    .setLabel("Healthcare");
  cp5.addTextfield("SAL")
   .setPosition(350,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[3]))
    .setLabel("Salaries");  
  cp5.addTextfield("MIL")
    .setPosition(420,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[4]))
    .setLabel("Military");
  cp5.addTextfield("OTH")
    .setPosition(490,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[5]))
    .setLabel("Other");
  cp5.addButton("GER")
    .setPosition(500,100)
    .setSize(100,100)
    .setLabel("Germany");
      cp5.addButton("JAP")
    .setPosition(300,100)
    .setSize(100,100)
    .setLabel("Japan");
          cp5.addButton("CHIN")
    .setPosition(100,100)
    .setSize(100,100)
    .setLabel("China");
              cp5.addButton("US")
    .setPosition(300,300)
    .setSize(100,100)
    .setLabel("United States");
  cp5.getController("NextTurn").hide();
  cp5.getController("MaxTaxBracket").hide();
  cp5.getController("InterestRate").hide();
  cp5.getController("MAN").hide();
  cp5.getController("WEL").hide();
  cp5.getController("HEL").hide();
  cp5.getController("SAL").hide();
  cp5.getController("MIL").hide();
  cp5.getController("OTH").hide();


    //Do this for all of them


  //I need nothing ever happens as an image
  //radio button as my event. Super events?More actions
  //
  //
}
void GER(){
   cp5.getController("JAP").hide();
     cp5.getController("GER").hide();
     cp5.getController("CHIN").hide();
     cp5.getController("US").hide();

    NAT.initializeNation ("Germany",0.01,2000.0,800.0,500.0,400.0,0.02,0.03,0.015,20.0,83000000,new double[]{140.0, 250.0, 200.0, 250.0, 110.0, 150.0},915.9,2000.0,0.45,915.9, 50.0);
  currentImage=1;
    cp5.addTextfield("MaxTaxBracket")
    .setPosition(0,0)
    .setSize(70,30)
    //.setRange(0.0,1.0)
    .setText(str((float) NAT.getNation().getMaxTaxBracket()))
    .setLabel("Max Tax Bracket");
  cp5.addTextfield("InterestRate") 
    .setPosition(70,0)
    .setSize(70,30)
    //.setRange(0.0, 3)
    .setText(str((float) NAT.getNation().getInterestRate()))
    .setLabel("Interest Rate")
  ;
    cp5.addTextfield("MAN")
    .setPosition(140,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[0]))
    .setLabel("Manufacturing");
  cp5.addTextfield("WEL")
    .setPosition(210,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[1]))
    .setLabel("Welfare");
  cp5.addTextfield("HEL")
  .setPosition(280,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[2]))
    .setLabel("Healthcare");
  cp5.addTextfield("SAL")
   .setPosition(350,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[3]))
    .setLabel("Salaries");  
  cp5.addTextfield("MIL")
    .setPosition(420,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[4]))
    .setLabel("Military");
  cp5.addTextfield("OTH")
    .setPosition(490,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[5]))
    .setLabel("Other");
  cp5.getController("NextTurn").show();
  cp5.getController("MaxTaxBracket").show();
  cp5.getController("InterestRate").show();
  cp5.getController("MAN").show();
  cp5.getController("WEL").show();
  cp5.getController("HEL").show();
  cp5.getController("SAL").show();
  cp5.getController("MIL").show();
  cp5.getController("OTH").show();
}

void JAP() {
   cp5.getController("JAP").hide();
     cp5.getController("GER").hide();
     cp5.getController("CHIN").hide();
     cp5.getController("US").hide();

   //double populationGrowthRate,double ConsumerSpending, double Investment,  double Exports, double Imports, double DefaultGDPGrowthRate, double interestRate, double inflationRate,double initialInterestPayment,double population, double[] govBudgetBreakDown, double taxRevenue, double initialnationalDebt, double maxTaxBracket, double spendableTaxRevenue, double joy
    //manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
  NAT.initializeNation ("Japan",-.049,1981.33,783.3,916.9,742.9,0.0149,0.005,0.036,169,123000000,new double[]{110.0, 338.0, 317.0, 100.0, 56.0, 200.0},1000,9000.0,0.40,1000, 100.0);
  currentImage=1;
    cp5.addTextfield("MaxTaxBracket")
    .setPosition(0,0)
    .setSize(70,30)
    //.setRange(0.0,1.0)
    .setText(str((float) NAT.getNation().getMaxTaxBracket()))
    .setLabel("Max Tax Bracket");
  cp5.addTextfield("InterestRate") 
    .setPosition(70,0)
    .setSize(70,30)
    //.setRange(0.0, 3)
    .setText(str((float) NAT.getNation().getInterestRate()))
    .setLabel("Interest Rate")
  ;
    cp5.addTextfield("MAN")
    .setPosition(140,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[0]))
    .setLabel("Manufacturing");
  cp5.addTextfield("WEL")
    .setPosition(210,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[1]))
    .setLabel("Welfare");
  cp5.addTextfield("HEL")
  .setPosition(280,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[2]))
    .setLabel("Healthcare");
  cp5.addTextfield("SAL")
   .setPosition(350,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[3]))
    .setLabel("Salaries");  
  cp5.addTextfield("MIL")
    .setPosition(420,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[4]))
    .setLabel("Military");
  cp5.addTextfield("OTH")
    .setPosition(490,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[5]))
    .setLabel("Other");
  cp5.getController("NextTurn").show();
  cp5.getController("MaxTaxBracket").show();
  cp5.getController("InterestRate").show();
  cp5.getController("MAN").show();
  cp5.getController("WEL").show();
  cp5.getController("HEL").show();
  cp5.getController("SAL").show();
  cp5.getController("MIL").show();
  cp5.getController("OTH").show(); 
}


void CHIN() {
   cp5.getController("JAP").hide();
     cp5.getController("GER").hide();
     cp5.getController("CHIN").hide();
     cp5.getController("US").hide();

   //double populationGrowthRate,double ConsumerSpending, double Investment,  double Exports, double Imports, double DefaultGDPGrowthRate, double interestRate, double inflationRate,double initialInterestPayment,double population, double[] govBudgetBreakDown, double taxRevenue, double initialnationalDebt, double maxTaxBracket, double spendableTaxRevenue, double joy
    //manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
//NAT.initializeNation("China",-.001,7680, 7290, 3510, 2590, .05, .03, .002, 170,14200000000 ,new double[]{110.0, 338.0, 317.0, 100.0, 56.0, 200.0},1000,9000.0,0.40,1000, 100.0);
  NAT.initializeNation ("China",-.001,7680,7290,3510,2590,0.05,.03,0.002,170, 1420000000,new double[]{400, 597, 1200, 300.0, 309.0, 300.0},2420,15000.0,0.45,2420, 120.0);

  currentImage=1;
    cp5.addTextfield("MaxTaxBracket")
    .setPosition(0,0)
    .setSize(70,30)
    //.setRange(0.0,1.0)
    .setText(str((float) NAT.getNation().getMaxTaxBracket()))
    .setLabel("Max Tax Bracket");
  cp5.addTextfield("InterestRate") 
    .setPosition(70,0)
    .setSize(70,30)
    //.setRange(0.0, 3)
    .setText(str((float) NAT.getNation().getInterestRate()))
    .setLabel("Interest Rate")
  ;
    cp5.addTextfield("MAN")
    .setPosition(140,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[0]))
    .setLabel("Manufacturing");
  cp5.addTextfield("WEL")
    .setPosition(210,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[1]))
    .setLabel("Welfare");
  cp5.addTextfield("HEL")
  .setPosition(280,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[2]))
    .setLabel("Healthcare");
  cp5.addTextfield("SAL")
   .setPosition(350,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[3]))
    .setLabel("Salaries");  
  cp5.addTextfield("MIL")
    .setPosition(420,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[4]))
    .setLabel("Military");
  cp5.addTextfield("OTH")
    .setPosition(490,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[5]))
    .setLabel("Other");
  cp5.getController("NextTurn").show();
  cp5.getController("MaxTaxBracket").show();
  cp5.getController("InterestRate").show();
  cp5.getController("MAN").show();
  cp5.getController("WEL").show();
  cp5.getController("HEL").show();
  cp5.getController("SAL").show();
  cp5.getController("MIL").show();
  cp5.getController("OTH").show(); 
}

void US() {
   cp5.getController("JAP").hide();
     cp5.getController("GER").hide();
     cp5.getController("CHIN").hide();
     cp5.getController("US").hide();

   //double populationGrowthRate,double ConsumerSpending, double Investment,  double Exports, double Imports, double DefaultGDPGrowthRate, double interestRate, double inflationRate,double initialInterestPayment,double population, double[] govBudgetBreakDown, double taxRevenue, double initialnationalDebt, double maxTaxBracket, double spendableTaxRevenue, double joy
    //manufacturing (standin for most subsidies), non healthcare welfare, healthcare, salaries (standin for most pensions and labor expenditures), millitary, anythingElse
//NAT.initializeNation("China",-.001,7680, 7290, 3510, 2590, .05, .03, .002, 170,14200000000 ,new double[]{110.0, 338.0, 317.0, 100.0, 56.0, 200.0},1000,9000.0,0.40,1000, 100.0);
  NAT.initializeNation ("United States", .005,16100,5.6,3100, 4100,0.028, .0425,.023, 684, 340000000,new double[]{200, 1200, 4900, 336, 997, 885},4920,34000,0.37,4920, 80.0);

  currentImage=1;
    cp5.addTextfield("MaxTaxBracket")
    .setPosition(0,0)
    .setSize(70,30)
    //.setRange(0.0,1.0)
    .setText(str((float) NAT.getNation().getMaxTaxBracket()))
    .setLabel("Max Tax Bracket");
  cp5.addTextfield("InterestRate") 
    .setPosition(70,0)
    .setSize(70,30)
    //.setRange(0.0, 3)
    .setText(str((float) NAT.getNation().getInterestRate()))
    .setLabel("Interest Rate")
  ;
    cp5.addTextfield("MAN")
    .setPosition(140,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[0]))
    .setLabel("Manufacturing");
  cp5.addTextfield("WEL")
    .setPosition(210,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[1]))
    .setLabel("Welfare");
  cp5.addTextfield("HEL")
  .setPosition(280,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[2]))
    .setLabel("Healthcare");
  cp5.addTextfield("SAL")
   .setPosition(350,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[3]))
    .setLabel("Salaries");  
  cp5.addTextfield("MIL")
    .setPosition(420,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[4]))
    .setLabel("Military");
  cp5.addTextfield("OTH")
    .setPosition(490,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[5]))
    .setLabel("Other");
  cp5.getController("NextTurn").show();
  cp5.getController("MaxTaxBracket").show();
  cp5.getController("InterestRate").show();
  cp5.getController("MAN").show();
  cp5.getController("WEL").show();
  cp5.getController("HEL").show();
  cp5.getController("SAL").show();
  cp5.getController("MIL").show();
  cp5.getController("OTH").show(); 
}




void NextTurn(){
  
    //System.out.println("{ressed");
    newBudget[0]=Double.parseDouble(cp5.get(Textfield.class,"MAN").getText());
    newBudget[1]=Double.parseDouble(cp5.get(Textfield.class,"WEL").getText());
    newBudget[2]=Double.parseDouble(cp5.get(Textfield.class,"HEL").getText());
    newBudget[3]=Double.parseDouble(cp5.get(Textfield.class,"SAL").getText());
    newBudget[4]=Double.parseDouble(cp5.get(Textfield.class,"MIL").getText());
    newBudget[5]=Double.parseDouble(cp5.get(Textfield.class,"OTH").getText());
    NAT.turn(newBudget,Double.parseDouble(cp5.get(Textfield.class,"InterestRate").getText()),Double.parseDouble(cp5.get(Textfield.class,"MaxTaxBracket").getText()));
    float Happening=random(1);
    if(NAT.getNation().getJoy()>=20){    
    if(Happening<0.3){
      Events.EventHappens(NAT.getNation());
      eventNew.setText("Guys, "+Events.getCurrent()).show();
      showSwitch=1;
    }
    else{
      eventNew.setText("Guys, nothing ever happens").show();
      showSwitch=2;
    } 
    times=millis();
   }
  else{
      cp5.getController("NextTurn").hide();
  cp5.getController("MaxTaxBracket").hide();
  cp5.getController("InterestRate").hide();
  cp5.getController("MAN").hide();
  cp5.getController("WEL").hide();
  cp5.getController("HEL").hide();
  cp5.getController("SAL").hide();
  cp5.getController("MIL").hide();
  cp5.getController("OTH").hide(); 
    currentImage=2;
  }
}

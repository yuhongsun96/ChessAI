public class Pieces{
  //K, Q, R, N, B, P, 0 for nothing
  char name;
  //1 for player 1, 2 for player 2, 0 for empty space
  int owner;

  public Pieces(){
    name = '0';
    owner = 0;
  }  

  public Pieces(char name, int owner){
  this.name = name;
  this.owner = owner;
  }

  public boolean verifyMove(int xstart, int ystart, int xend, int yend){
    if(xend > 7 || xend < 0 || yend > 7 || yend < 0){
      return false;
    }
    
    switch(name){
      case 'K': if((xend - xstart == 0 || xend - xstart == 1 || xend - xstart == -1) &&
                   (yend - ystart == 0 || yend - ystart == 1 || yend - ystart == -1)){
                  return true;
                }
                else{
                  return false;
                }
      case 'Q': if((xend - xstart == yend - ystart) ||
                   (xend - xstart == -(yend - ystart)) ||
                   (xend == xstart) || (yend == ystart)){
                  return true;
                }
                else{
                  return false;
                }
      case 'R': if(xend == xstart || yend == ystart){
                  return true;
                }
                else{
                  return false;
                }
      case 'N': if(xend - xstart == 1 || xend - xstart == -1){
                  if(yend - ystart == 2 || yend - ystart == -2){
                    return true;
                  }
                  else{
                    return false;
                  }
                }
                else if(xend - xstart == 2 || xend - xstart == -2){
                  if(yend - ystart == 1 || yend - ystart == -1){
                    return true;
                  }
                  else{
                    return false;
                  }
                }
                else{
                  return false;
                }
      case 'B': if((xend - xstart == yend - ystart) || (xend - xstart == -(yend - ystart))){
                  return true;
                }
                else{
                  return false;
                }
      case 'P': System.out.printf("Pawns should not be handled here"); // handled seperately by verifyPawnMove
                return false;
      case '0': return false;
      default : return false;
    }
  }
  
  //true for enemy piece at left middle or right
  public boolean verifyPawnMove(int xstart, int ystart, int xend, int yend, boolean left, boolean middle, boolean right){
    if(owner == 1){
      if(xend == xstart && yend - ystart == 1 && middle == false){
        return true;
      }
      if(xend == xstart + 1 && yend - ystart == 1 && right == true){
        return true;
      }
      if(xend == xstart - 1 && yend - ystart == 1 && left == true){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      if(xend == xstart && yend - ystart == -1 && middle == false){
        return true;
      }
      if(xend == xstart + 1 && yend - ystart == -1 && right == true){
        return true;
      }
      if(xend == xstart - 1 && yend - ystart == -1 && left == true){
        return true;
      }
      else{
        return false;
      }
    }
  }
}

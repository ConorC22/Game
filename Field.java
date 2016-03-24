 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

public class Field extends JLabel{

private boolean snakeOrLadder;
private boolean snake, ladder;
private Field next;
private int x,y;

public Field(){
	snake = false;
	ladder = false;
}

public boolean hasSnakeOrLadder(){
	return snakeOrLadder;
}

public void setNext(Field n){
	next = n;
}

public Field getNext(){
	return next;
}

public int getXCoordinate(){
	return x;
}

public int getYCoordinate(){
	return y;
}

public void setXCoordinate(int x){
	this.x = x;
}

public void setYCoordinate(int y){
	this.y = y;
}

}
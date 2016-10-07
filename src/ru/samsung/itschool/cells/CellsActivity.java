 package ru.samsung.itschool.cells;

import task.Stub;
import task.Task;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;

public class CellsActivity extends Activity implements OnClickListener,
		OnLongClickListener {

	int WIDTH = 10;
	int HEIGHT = 10;

	Button[][] cell;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cells);
		
		generate();
	
	}

	void generate() {

		Task.showMessage(this, "Добавьте код в функцию активности generate для генерации клеточного поля");
		
		makeCells();

		for (int i = 0; i < HEIGHT; i++)
			for (int j = 0; j < WIDTH; j++) {
				//ADD YOUR CODE HERE
				//....
				
			}
	}

	@Override
	public boolean onLongClick(View v) {
		Stub.show(this, "Добавьте код в функцию активности onLongClick - реакцию на долгое нажатие на клетку");
		return false;
	}

	@Override
	public void onClick(View v) {
		
		Stub.show(this, "Добавьте код в функцию активности onClick - реакцию на нажатие на клетку");
		
		Button tappedCell = (Button) v;
		
		//Получаем координтаты нажатой клетки
		int tappedX = getX(tappedCell);
		int tappedY = getY(tappedCell);
		//ADD YOUR CODE HERE
		//....

	}

	/*
	 * NOT FOR THE BEGINNERS 
	 */
	
	int getX(View v)
	{
		return Integer.parseInt(((String)v.getTag()).split(",")[1]); 
	}
	
	int getY(View v)
	{
		return Integer.parseInt(((String)v.getTag()).split(",")[0]);
	}

	void makeCells() {
		cell = new Button[HEIGHT][WIDTH];
		GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
		cellsLayout.removeAllViews();
		cellsLayout.setColumnCount(HEIGHT);
		for (int i = 0; i < HEIGHT; i++)
			for (int j = 0; j < WIDTH; j++) {
				LayoutInflater inflater = (LayoutInflater) getApplicationContext()
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				cell[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
				cell[i][j].setOnClickListener(this);
				cell[i][j].setOnLongClickListener(this);
				cell[i][j].setTag(i+","+j);
				cellsLayout.addView(cell[i][j]);
			}
	}
	
}
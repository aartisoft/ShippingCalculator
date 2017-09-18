package edu.orangecoastcollege.cs273.phuynh101.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat mCurrency = NumberFormat.getCurrencyInstance();

    //connections from Control to View
    private EditText mWeightEditText;
    private TextView mBaseCostTextView;
    private TextView mAddedCostTextView;
    private TextView mTotalCostTextView;

    //Connections from Control to Model
    private ShipItem mShipItem = new ShipItem();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeightEditText = (EditText) findViewById(R.id.weightEditText);
        mBaseCostTextView = (TextView) findViewById(R.id.baseCostTextView);
        mAddedCostTextView = (TextView) findViewById(R.id.addedCostTextView);
        mTotalCostTextView = (TextView) findViewById(R.id.totalCostTextView);

        mWeightEditText.requestFocus();
        mWeightEditText.addTextChangedListener(mTextWatcher);

        mWeightEditText.setText(String.valueOf(0));
        mShipItem.setWeight(0);
    }

    private void updateViews()
    {
        mBaseCostTextView.setText(mCurrency.format(mShipItem.getBase_cost()));
        mAddedCostTextView.setText(mCurrency.format(mShipItem.getAdded_cost()));
        mTotalCostTextView.setText(mCurrency.format(mShipItem.getTotal_cost()));
    }
    private final TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence value, int i, int i1, int i2) {
            try {
                mShipItem.setWeight(Integer.parseInt(value.toString()));
            }catch(NumberFormatException e)
            {
                mShipItem.setWeight(0);
            }
            updateViews();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}

package com.dd.learnjavamethods.View.DetailedActivity.Presenter;


import com.dd.learnjavamethods.View.ConstantsOfApp;
import com.dd.learnjavamethods.View.DetailedActivity.View.IView;

import bsh.EvalError;
import bsh.Interpreter;

public class Presenter implements IPresenter {

    private IView iView;

    public Presenter(IView iView) {
        this.iView = iView;
    }

    private String getParamTexts(String s) {
        switch (s) {
            case ConstantsOfApp.INT_PARAM:
                return "1;";
            case ConstantsOfApp.DOUBLE_PARAM:
                return "1.0;";
            case ConstantsOfApp.DOUBLE_ARRAY_PARAM:
                return "{1.0, 2.0, 3.0};";
            case ConstantsOfApp.FLOAT_PARAM:
                return "1.0f;";
            case ConstantsOfApp.FLOAT_ARRAY_PARAM:
                return "{1f, 2.0f, 3.0f};";
            case ConstantsOfApp.INT_ARRAY_PARAM:
                return "{1, 2, 3};";
            case ConstantsOfApp.INTEGER_PARAM:
                return "1;";
            case ConstantsOfApp.LONG_PARAM:
                return "1L;";
            case ConstantsOfApp.LONG_ARRAY_PARAM:
                return "{1L, 2L, 3L};";
            case ConstantsOfApp.OBJECT_PARAM:
                return "\"a\";";
            case ConstantsOfApp.OBJECT_ARRAY_PARAM:
                return "{\"any\", \"text\"};";
            case ConstantsOfApp.SHORT_PARAM:
                return "1;";
            case ConstantsOfApp.SHORT_ARRAY_PARAM:
                return "{1, 2, 3};";
            case ConstantsOfApp.STRING_PARAM:
                return "\"any\";";
            case ConstantsOfApp.STRINGBUFFER_PARAM:
                return "new StringBuffer(\"anytext\");";
            case ConstantsOfApp.BOOLEAN_PARAM:
                return "true;";
            case ConstantsOfApp.BOOLEAN_ARRAY_PARAM:
                return "{true,false};";
            case ConstantsOfApp.BYTE_PARAM:
                return "1;";
            case ConstantsOfApp.BYTE_ARRAY_PARAM:
                return "{1, 2, 3};";
            case ConstantsOfApp.CALENDAR_PARAM:
                return "Calendar.getInstance();";
            case ConstantsOfApp.CHAR_PARAM:
                return "'a';";
            case ConstantsOfApp.CHAR_ARRAY_PARAM:
                return "{'a', 'n', 'y'};";
            case ConstantsOfApp.CHARACTER_PARAM:
                return "'a';";
            case ConstantsOfApp.CHARSEQUENCE_PARAM:
                return "\"abc\";";
            case ConstantsOfApp.CHARSET_PARAM:
                return "Charset.forName(\"UTF-8\");";

            case ConstantsOfApp.U_ARRAY_PARAM:
                return "{'a', 'n', 'y'};";
            case ConstantsOfApp.T_ARRAY_PARAM:
                return "{'a', 'n', 'y'};";
            case ConstantsOfApp.T_DOTS_PARAM:
                return "{'a', 'n', 'y'};";
            case ConstantsOfApp.OBJECT_DOTS_PARAM:
                return "{\"a\", \"n\", \"y\"};";
            case ConstantsOfApp.T_PARAM:
                return "new String();";
            case ConstantsOfApp.E_PARAM:
                return "new String();";
            case ConstantsOfApp.TIMEZONE_PARAM:
                return "TimeZone.getDefault();";
            case ConstantsOfApp.LOCALE_PARAM:
                return "new Locale(\"fr\");";
            case ConstantsOfApp.DATE_PARAM:
                return "new Date();";
            case ConstantsOfApp.COMPARATOR_SUPER_T_PARAM:
                return "null;";
            case ConstantsOfApp.COLLECTION_EXTENDS_E_PARAM:
                return "[\"a\", \"n\", \"y\"];";
            case ConstantsOfApp.COLLECTION_PARAM:
                return "[\"a\", \"n\", \"y\"];";

            default:
                return "";
        }

    }

    private String editQuoteClicked(String s) {
        if (!s.isEmpty()) {
            if (!s.substring(0, 1).equals("\"") & !s.substring(s.length() - 1).equals("\"")) {
                s = "\"" + s + "\"";
            } else {
                s = s.substring(1, s.length() - 1);
            }
        }
        return s;
    }

    @Override
    public void setEditTextChangedListener() {
        iView.setEditTextChangedListener();
    }

    @Override
    public void setDataToViewsReceivedFromPreviousActivity() {
        iView.setDataToViewsReceivedFromPreviousActivity();
    }

    @Override
    public void setDataFromPreviousActivity() {
        iView.setDataFromPreviousActivity();
    }

    @Override
    public void setSplitParamsArray() {
        String getIntentMethod = iView.getTextGetIntentMethod();
        getIntentMethod = getIntentMethod.substring(getIntentMethod.indexOf("(") + 1, getIntentMethod.indexOf(")"));
        String[] splitParamsArray = getIntentMethod.split(", ");

        iView.setSplitParamsArray(splitParamsArray);
    }

    @Override
    public void setSplitParamsArrayOnlyType() {
        String[] splitParamsArray = iView.getSplitParamsArray();

        int i;
        String paramType;
        switch (splitParamsArray.length) {
            case 8:
                i = splitParamsArray[7].indexOf(' ');
                splitParamsArray[7] = splitParamsArray[7].substring(0, i);

            case 7:
                i = splitParamsArray[6].indexOf(' ');
                splitParamsArray[6] = splitParamsArray[6].substring(0, i);

            case 6:
                i = splitParamsArray[5].indexOf(' ');
                splitParamsArray[5] = splitParamsArray[5].substring(0, i);

            case 5:
                i = splitParamsArray[4].indexOf(' ');
                splitParamsArray[4] = splitParamsArray[4].substring(0, i);

            case 4:
                i = splitParamsArray[3].indexOf(' ');
                splitParamsArray[3] = splitParamsArray[3].substring(0, i);

            case 3:

                i = splitParamsArray[2].indexOf(' ');
                splitParamsArray[2] = splitParamsArray[2].substring(0, i);

            case 2:
                i = splitParamsArray[1].indexOf(' ');
                splitParamsArray[1] = splitParamsArray[1].substring(0, i);

            case 1:
                if (splitParamsArray[0].equals("")) {
                    break;
                }
                i = splitParamsArray[0].indexOf(' ');
                splitParamsArray[0] = splitParamsArray[0].substring(0, i);

            default:
                break;

        }

        iView.setSplitParamsArrayOnlyType(splitParamsArray);
    }

    @Override
    public void setInitialTextToParams() {
        String[] splitParamsArrayOnlyType = iView.getSplitParamsArrayOnlyType();

        String paramValue;
        switch (splitParamsArrayOnlyType.length) {
            case 8:
                paramValue = splitParamsArrayOnlyType[7] + " param8 = " + getParamTexts(splitParamsArrayOnlyType[7]);
                iView.setTextEtParam8(paramValue);

            case 7:
                paramValue = splitParamsArrayOnlyType[6] + " param7 = " + getParamTexts(splitParamsArrayOnlyType[6]);
                iView.setTextEtParam7(paramValue);

            case 6:
                paramValue = splitParamsArrayOnlyType[5] + " param6 = " + getParamTexts(splitParamsArrayOnlyType[5]);
                iView.setTextEtParam6(paramValue);

            case 5:
                paramValue = splitParamsArrayOnlyType[4] + " param5 = " + getParamTexts(splitParamsArrayOnlyType[4]);
                iView.setTextEtParam5(paramValue);

            case 4:
                paramValue = splitParamsArrayOnlyType[3] + " param4 = " + getParamTexts(splitParamsArrayOnlyType[3]);
                iView.setTextEtParam4(paramValue);

            case 3:
                paramValue = splitParamsArrayOnlyType[2] + " param3 = " + getParamTexts(splitParamsArrayOnlyType[2]);
                iView.setTextEtParam3(paramValue);

            case 2:
                paramValue = splitParamsArrayOnlyType[1] + " param2 = " + getParamTexts(splitParamsArrayOnlyType[1]);
                iView.setTextEtParam2(paramValue);

            case 1:
                if (splitParamsArrayOnlyType[0].equals("")) {
                    break;
                }
                paramValue = splitParamsArrayOnlyType[0] + " param1 = " + getParamTexts(splitParamsArrayOnlyType[0]);
                iView.setTextEtParam1(paramValue);

            default:
                break;

        }
    }

    @Override
    public void setViewsVisibility() {

        String[] strings = iView.getSplitParamsArray();
        switch (strings.length) {
            case 8:
                iView.setVisibileQuotesParam8Iv();
                iView.setVisibileDeleteParam8Iv();
                iView.setVisibleEtParam8();
                iView.setHintTomEtParam8(strings[7].trim());

            case 7:
                iView.setVisibileQuotesParam7Iv();
                iView.setVisibileDeleteParam7Iv();
                iView.setVisibleEtParam7();
                iView.setHintTomEtParam7(strings[6].trim());

            case 6:
                iView.setVisibileQuotesParam6Iv();
                iView.setVisibileDeleteParam6Iv();
                iView.setVisibleEtParam6();
                iView.setHintTomEtParam6(strings[5].trim());

            case 5:
                iView.setVisibileQuotesParam5Iv();
                iView.setVisibileDeleteParam5Iv();
                iView.setVisibleEtParam5();
                iView.setHintTomEtParam5(strings[4].trim());

            case 4:
                iView.setVisibileQuotesParam4Iv();
                iView.setVisibileDeleteParam4Iv();
                iView.setVisibleEtParam4();
                iView.setHintTomEtParam4(strings[3].trim());

            case 3:
                iView.setVisibileQuotesParam3Iv();
                iView.setVisibileDeleteParam3Iv();
                iView.setVisibleEtParam3();
                iView.setHintTomEtParam3(strings[2].trim());

            case 2:
                iView.setVisibileQuotesParam2Iv();
                iView.setVisibileDeleteParam2Iv();
                iView.setVisibleEtParam2();
                iView.setHintTomEtParam2(strings[1].trim());

            case 1:
                if (strings[0].equals("")) {
                    break;
                }
                iView.setVisibileQuotesParam1Iv();
                iView.setVisibileDeleteParam1Iv();
                iView.setVisibleEtParam1();
                iView.setHintTomEtParam1(strings[0]);
                iView.setVisibleEnterParamsTv();
                iView.setVisibleLineParamsView();

            default:
                break;

        }

    }

    @Override
    public void onEtEnterValueDeleteClicked() {
        iView.setTextEtEnterValue("");
    }

    @Override
    public void onEtParam1DeleteClicked() {
        iView.setTextEtParam1("");
    }

    @Override
    public void onEtParam2DeleteClicked() {
        iView.setTextEtParam2("");
    }

    @Override
    public void onEtParam3DeleteClicked() {
        iView.setTextEtParam3("");
    }

    @Override
    public void onEtParam4DeleteClicked() {
        iView.setTextEtParam4("");
    }

    @Override
    public void onEtParam5DeleteClicked() {
        iView.setTextEtParam5("");
    }

    @Override
    public void onEtParam6DeleteClicked() {
        iView.setTextEtParam6("");
    }

    @Override
    public void onEtParam7DeleteClicked() {
        iView.setTextEtParam7("");
    }

    @Override
    public void onEtParam8DeleteClicked() {
        iView.setTextEtParam8("");
    }

    @Override
    public void onEtEnterValueQuoteClicked() {
        String s = iView.getTextEtEnterValue();
        iView.setTextEtEnterValue(editQuoteClicked(s));
    }

    @Override
    public void onmEtParam1QuoteClicked() {
        String s = iView.getTextEtParam1();
        iView.setTextEtParam1(editQuoteClicked(s));
    }

    @Override
    public void onmEtParam2QuoteClicked() {
        String s = iView.getTextEtParam2();
        iView.setTextEtParam2(editQuoteClicked(s));
    }

    @Override
    public void onmEtParam3QuoteClicked() {
        String s = iView.getTextEtParam3();
        iView.setTextEtParam3(editQuoteClicked(s));
    }

    @Override
    public void onmEtParam4QuoteClicked() {

        String s = iView.getTextEtParam4();
        iView.setTextEtParam4(editQuoteClicked(s));
    }

    @Override
    public void onmEtParam5QuoteClicked() {
        String s = iView.getTextEtParam5();
        iView.setTextEtParam5(editQuoteClicked(s));
    }

    @Override
    public void onmEtParam6QuoteClicked() {
        String s = iView.getTextEtParam6();
        iView.setTextEtParam6(editQuoteClicked(s));
    }

    @Override
    public void onmEtParam7QuoteClicked() {
        String s = iView.getTextEtParam7();
        iView.setTextEtParam7(editQuoteClicked(s));
    }

    @Override
    public void onmEtParam8QuoteClicked() {
        String s = iView.getTextEtParam8();
        iView.setTextEtParam8(editQuoteClicked(s));
    }

    //execute java code using BeenShell library
    @Override
    public void onExecuteCodeFromTv() {
        String code = iView.getTextCodeEt();
        try {
            Interpreter i = new Interpreter();  // Construct an interpreter
            i.eval(code);

            code = "a = " + String.valueOf(i.get("a"));
        } catch (EvalError evalError) {
            evalError.printStackTrace();
            code = "null";
        }

        iView.setTextTvResult(code);
    }

    @Override
    public void onSetInitialTextToEnterValue() {

        String getIntentObject = iView.getTextGetIntentObject();
        String s = "";
        switch (getIntentObject) {
            case ConstantsOfApp.STRING_OBJECT:
                s = "\"anytext\"";
                break;
            case ConstantsOfApp.INTEGER_OBJECT:
                s = "123";
                break;
            case ConstantsOfApp.ARRAYS_OBJECT://-?
                s = "\"anytext\"";
                break;
            case ConstantsOfApp.STRINGBUILDER_OBJECT://-?
                s = "\"anytext\"";
                break;
            case ConstantsOfApp.CALENDAR_OBJECT://-?
                s = "\"anytext\"";
                break;
            case ConstantsOfApp.SHORT_OBJECT:
                s = "123";
                break;
            case ConstantsOfApp.BYTE_OBJECT:
                s = "a";
                break;
            case ConstantsOfApp.BOOLEAN_OBJECT:
                s = "true";
                break;
            case ConstantsOfApp.LONG_OBJECT:
                s = "123";
                break;
            case ConstantsOfApp.DOUBLE_OBJECT:
                s = "123.0";
                break;
            case ConstantsOfApp.FLOAT_OBJECT:
                s = "123.0f";
                break;
            case ConstantsOfApp.CHARACTER_OBJECT:
                s = "\'a\'";
                break;
            case ConstantsOfApp.ARRAYLIST_OBJECT://-?
                s = "\"anytext\"";
                break;

        }
        iView.setTextEtEnterValue(s);

    }

    @Override
    public void onFormCodeAndSetToTv() {
        String codeToTv = "";

        String getIntentObject = iView.getTextGetIntentObject();
        String mEtEnterValue = iView.getTextEtEnterValue();
        String mTvType = iView.getTextTvType();
        String mTvMethod = iView.getTextTvMethod();

        String tempParamsText = iView.getTextTempParamsText();
        String[] tempStrings = tempParamsText.split(" =");
        String tempParamNames = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tempStrings.length - 1; i++) {
            stringBuilder.append(tempStrings[i].substring(tempStrings[i].length() - 6));
            stringBuilder.append(",");
        }
        if (stringBuilder.toString().length() - 1 >= 0) {
            tempParamNames = stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
        }


        switch (getIntentObject) {
            case ConstantsOfApp.STRING_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.INTEGER_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.ARRAYS_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.STRINGBUILDER_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.CALENDAR_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.SHORT_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.BYTE_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.BOOLEAN_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.LONG_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.DOUBLE_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.FLOAT_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.CHARACTER_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;
            case ConstantsOfApp.ARRAYLIST_OBJECT:

                codeToTv = String.format("%s s = %s;\n\n" +
                                "%s \n" +
                                "%s a = s.%s%s);",
                        getIntentObject, mEtEnterValue.trim(),
                        tempParamsText,
                        mTvType, mTvMethod.substring(0, mTvMethod.indexOf("(") + 1), tempParamNames
                );
                break;

        }

        iView.setTextCodeEt(codeToTv);

    }

    @Override
    public void onFormTextFromParams() {

        String mEtParam1 = iView.getTextEtParam1();
        String mEtParam2 = iView.getTextEtParam2();
        String mEtParam3 = iView.getTextEtParam3();
        String mEtParam4 = iView.getTextEtParam4();
        String mEtParam5 = iView.getTextEtParam5();
        String mEtParam6 = iView.getTextEtParam6();
        String mEtParam7 = iView.getTextEtParam7();
        String mEtParam8 = iView.getTextEtParam8();

        StringBuilder stringBuilder = new StringBuilder();

        //if param1 is not empty, then do: get text from param1 from EditText
        if (!mEtParam1.trim().equals("")) {
            stringBuilder.append(mEtParam1.trim() + "\n");
        }
        if (!mEtParam2.trim().equals("")) {
            stringBuilder.append(mEtParam2.trim() + "\n");
        }
        if (!mEtParam3.trim().equals("")) {
            stringBuilder.append(mEtParam3.trim() + "\n");
        }
        if (!mEtParam4.trim().equals("")) {
            stringBuilder.append(mEtParam4.trim() + "\n");
        }
        if (!mEtParam5.trim().equals("")) {
            stringBuilder.append(mEtParam5.trim() + "\n");
        }
        if (!mEtParam6.trim().equals("")) {
            stringBuilder.append(mEtParam6.trim() + "\n");
        }
        if (!mEtParam7.trim().equals("")) {
            stringBuilder.append(mEtParam7.trim() + "\n");
        }
        if (!mEtParam8.trim().equals("")) {
            stringBuilder.append(mEtParam8.trim() + "\n");
        }


        iView.setTextTempParamsText(stringBuilder.toString());
    }
}





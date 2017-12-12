package wj.com.moham.common.model.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import wj.com.moham.R;
import wj.com.moham.common.util.Util;

/**
 * Created by admin on 2017. 11. 8..
 */

public class DialogMoham {

    private OnAlertClickListener mOnAlertClickListener;
    private OnConfirmClickListener mOnConfirmClickListener;

    public void showConfirmDialog(Context pContext, String pContent) {
        final Dialog dialog = new Dialog(pContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm);
        setDialogSize(dialog);

        LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_dialog_title);
        TextView txtTitle = (TextView) dialog.findViewById(R.id.txt_dialog_title);
        TextView txtContent = (TextView) dialog.findViewById(R.id.txt_dialog_content);
        Button btnConfirm = (Button) dialog.findViewById(R.id.btn_dialog_confirm);

        layoutTitle.setVisibility(View.GONE);
        txtTitle.setText("");

        txtContent.setText(pContent);

        dialog.setCancelable(false);
        dialog.show();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                mOnConfirmClickListener.onClickConfirmButton(dialog);
            }
        });
    }

    public void showConfirmDialog(Context pContext, String pTitle, String pContent) {
        if (pTitle == null) {
            showConfirmDialog(pContext, pContent);
        } else {
            final Dialog dialog = new Dialog(pContext);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_confirm);
            setDialogSize(dialog);

            LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_dialog_title);
            TextView txtTitle = (TextView) dialog.findViewById(R.id.txt_dialog_title);
            TextView txtContent = (TextView) dialog.findViewById(R.id.txt_dialog_content);
            Button btnConfirm = (Button) dialog.findViewById(R.id.btn_dialog_confirm);

            if ("".equals(pTitle)) {
                layoutTitle.setVisibility(View.GONE);
            } else {
                layoutTitle.setVisibility(View.VISIBLE);
                txtTitle.setText(pTitle);
            }

            txtContent.setText(pContent);

            dialog.setCancelable(false);
            dialog.show();

            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    mOnConfirmClickListener.onClickConfirmButton(dialog);
                }
            });
        }
    }


    public void showNoticeDialog(Context pContext, String pContent) {
        final Dialog dialog = new Dialog(pContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm);
        setDialogSize(dialog);

        LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_dialog_title);
        TextView txtTitle = (TextView) dialog.findViewById(R.id.txt_dialog_title);
        TextView txtContent = (TextView) dialog.findViewById(R.id.txt_dialog_content);
        Button btnConfirm = (Button) dialog.findViewById(R.id.btn_dialog_confirm);

        layoutTitle.setVisibility(View.GONE);
        txtTitle.setText("");

        txtContent.setText(pContent);

        dialog.setCancelable(false);
        dialog.show();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.cancel();
            }
        });
    }

    public void showNoticeDialog(Context pContext, String pTitle, String pContent) {
        if (pTitle == null) {
            showNoticeDialog(pContext, pContent);
        } else {
            final Dialog dialog = new Dialog(pContext);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_confirm);
            setDialogSize(dialog);

            LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_dialog_title);
            TextView txtTitle = (TextView) dialog.findViewById(R.id.txt_dialog_title);
            TextView txtContent = (TextView) dialog.findViewById(R.id.txt_dialog_content);
            Button btnConfirm = (Button) dialog.findViewById(R.id.btn_dialog_confirm);

            if ("".equals(pTitle)) {
                layoutTitle.setVisibility(View.GONE);
            } else {
                layoutTitle.setVisibility(View.VISIBLE);
                txtTitle.setText(pTitle);
            }

            txtContent.setText(pContent);

            dialog.setCancelable(false);
            dialog.show();

            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    dialog.cancel();
                }
            });
        }
    }


    public void showConfirmFinishDialog(Context pContext, String pContent) {
        final Dialog dialog = new Dialog(pContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm);
        setDialogSize(dialog);

        final Activity pActivity = (Activity) pContext;
        LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_dialog_title);
        TextView txtTitle = (TextView) dialog.findViewById(R.id.txt_dialog_title);
        TextView txtContent = (TextView) dialog.findViewById(R.id.txt_dialog_content);
        Button btnConfirm = (Button) dialog.findViewById(R.id.btn_dialog_confirm);

        layoutTitle.setVisibility(View.GONE);
        txtTitle.setText("");

        txtContent.setText(pContent);

        dialog.setCancelable(false);
        dialog.show();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                onClickFinishButton(pActivity, dialog);
            }
        });
    }

    public void showConfirmFinishDialog(Context pContext, String pTitle, String pContent) {
        if (pTitle == null) {
            showConfirmFinishDialog(pContext, pContent);
        } else {
            final Dialog dialog = new Dialog(pContext);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_confirm);
            setDialogSize(dialog);

            final Activity pActivity = (Activity) pContext;
            LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_dialog_title);
            TextView txtTitle = (TextView) dialog.findViewById(R.id.txt_dialog_title);
            TextView txtContent = (TextView) dialog.findViewById(R.id.txt_dialog_content);
            Button btnConfirm = (Button) dialog.findViewById(R.id.btn_dialog_confirm);

            if ("".equals(pTitle)) {
                layoutTitle.setVisibility(View.GONE);
            } else {
                layoutTitle.setVisibility(View.VISIBLE);
                txtTitle.setText(pTitle);
            }

            txtContent.setText(pContent);

            dialog.setCancelable(false);
            dialog.show();

            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    onClickFinishButton(pActivity, dialog);
                }
            });
        }
    }


    public void showAlertDialog(Context pContext, String pContent) {
        final Dialog dialog = new Dialog(pContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_alert);
        setDialogSize(dialog);

        LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_alert_title);
        TextView txtTitle = (TextView) dialog.findViewById(R.id.textview_alert_title);
        TextView txtContent = (TextView) dialog.findViewById(R.id.textview_alert_content);
        Button btnConfirm = (Button) dialog.findViewById(R.id.btn_alert_confirm);
        Button btnCancel = (Button) dialog.findViewById(R.id.btn_alert_cancel);

        layoutTitle.setVisibility(View.GONE);
        txtTitle.setText("");

        txtContent.setText(pContent);

        dialog.setCancelable(false);
        dialog.show();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                mOnAlertClickListener.onClickPositiveButton(dialog);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                mOnAlertClickListener.onClickNegativeButton(dialog);
            }
        });
    }

    public void showAlertDialog(Context pContext, String pTitle, String pContent) {
        if (pTitle == null) {
            showAlertDialog(pContext, pContent);
        } else {
            final Dialog dialog = new Dialog(pContext);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_alert);
            setDialogSize(dialog);

            LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_alert_title);
            TextView txtTitle = (TextView) dialog.findViewById(R.id.textview_alert_title);
            TextView txtContent = (TextView) dialog.findViewById(R.id.textview_alert_content);
            Button btnConfirm = (Button) dialog.findViewById(R.id.btn_alert_confirm);
            Button btnCancel = (Button) dialog.findViewById(R.id.btn_alert_cancel);

            if ("".equals(pTitle)) {
                layoutTitle.setVisibility(View.GONE);
            } else {
                layoutTitle.setVisibility(View.VISIBLE);
                txtTitle.setText(pTitle);
            }

            txtContent.setText(pContent);

            dialog.setCancelable(false);
            dialog.show();

            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    mOnAlertClickListener.onClickPositiveButton(dialog);
                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    mOnAlertClickListener.onClickNegativeButton(dialog);
                }
            });
        }
    }

    public void showAlertDialog(Context pContext, String pContent, String pBtnConfirmText, String pBtnCancelText) {
        if (pBtnConfirmText == null || pBtnCancelText == null) {
            showAlertDialog(pContext, pContent);
        } else {
            final Dialog dialog = new Dialog(pContext);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_alert);
            setDialogSize(dialog);

            LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_alert_title);
            TextView txtTitle = (TextView) dialog.findViewById(R.id.textview_alert_title);
            TextView txtContent = (TextView) dialog.findViewById(R.id.textview_alert_content);
            Button btnConfirm = (Button) dialog.findViewById(R.id.btn_alert_confirm);
            Button btnCancel = (Button) dialog.findViewById(R.id.btn_alert_cancel);

            layoutTitle.setVisibility(View.GONE);
            txtTitle.setText("");

            txtContent.setText(pContent);

            dialog.setCancelable(false);
            dialog.show();

            if ("".equals(pBtnConfirmText)) {
                btnConfirm.setText(pContext.getString(R.string.ok));
            } else {
                btnConfirm.setText(pBtnConfirmText);
            }
            if ("".equals(pBtnCancelText)) {
                btnCancel.setText(pContext.getString(R.string.cancel));
            } else {
                btnCancel.setText(pBtnCancelText);
            }

            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    mOnAlertClickListener.onClickPositiveButton(dialog);
                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    mOnAlertClickListener.onClickNegativeButton(dialog);
                }
            });
        }
    }

    public void showAlertDialog(Context pContext, String pTitle, String pContent, String pBtnConfirmText, String pBtnCancelText) {
        if (pTitle == null) {
            showAlertDialog(pContext, pContent, pBtnConfirmText, pBtnCancelText);
        } else if (pBtnConfirmText == null || pBtnCancelText == null) {
            showAlertDialog(pContext, pTitle, pContent);
        } else {
            final Dialog dialog = new Dialog(pContext);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_alert);
            setDialogSize(dialog);

            LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_alert_title);
            TextView txtTitle = (TextView) dialog.findViewById(R.id.textview_alert_title);
            TextView txtContent = (TextView) dialog.findViewById(R.id.textview_alert_content);
            Button btnConfirm = (Button) dialog.findViewById(R.id.btn_alert_confirm);
            Button btnCancel = (Button) dialog.findViewById(R.id.btn_alert_cancel);

            if ("".equals(pTitle)) {
                layoutTitle.setVisibility(View.GONE);
            } else {
                layoutTitle.setVisibility(View.VISIBLE);
                txtTitle.setText(pTitle);
            }

            txtContent.setText(pContent);

            dialog.setCancelable(false);
            dialog.show();

            if ("".equals(pBtnConfirmText)) {
                btnConfirm.setText(pContext.getString(R.string.ok));
            } else {
                btnConfirm.setText(pBtnConfirmText);
            }
            if ("".equals(pBtnCancelText)) {
                btnCancel.setText(pContext.getString(R.string.cancel));
            } else {
                btnCancel.setText(pBtnCancelText);
            }

            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    mOnAlertClickListener.onClickPositiveButton(dialog);
                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    mOnAlertClickListener.onClickNegativeButton(dialog);
                }
            });
        }
    }

    public void showAlertFinishDialog(Context pContext, String pContent) {
        final Dialog dialog = new Dialog(pContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_alert);
        setDialogSize(dialog);

        final Activity pActivity = (Activity) pContext;
        LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_alert_title);
        TextView txtTitle = (TextView) dialog.findViewById(R.id.textview_alert_title);
        TextView txtContent = (TextView) dialog.findViewById(R.id.textview_alert_content);
        Button btnConfirm = (Button) dialog.findViewById(R.id.btn_alert_confirm);
        Button btnCancel = (Button) dialog.findViewById(R.id.btn_alert_cancel);

        layoutTitle.setVisibility(View.GONE);
        txtTitle.setText("");

        txtContent.setText(pContent);

        dialog.setCancelable(false);
        dialog.show();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                onClickFinishButton(pActivity, dialog);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickConfirmButton(dialog);
            }
        });
    }

    public void showAlertFinishDialog(Context pContext, String pTitle, String pContent) {
        if (pTitle == null) {
            showAlertFinishDialog(pContext, pContent);
        } else {
            final Dialog dialog = new Dialog(pContext);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_alert);
            setDialogSize(dialog);

            final Activity pActivity = (Activity) pContext;
            LinearLayout layoutTitle = (LinearLayout) dialog.findViewById(R.id.layout_alert_title);
            TextView txtTitle = (TextView) dialog.findViewById(R.id.textview_alert_title);
            TextView txtContent = (TextView) dialog.findViewById(R.id.textview_alert_content);
            Button btnConfirm = (Button) dialog.findViewById(R.id.btn_alert_confirm);
            Button btnCancel = (Button) dialog.findViewById(R.id.btn_alert_cancel);

            if ("".equals(pTitle)) {
                layoutTitle.setVisibility(View.GONE);
            } else {
                layoutTitle.setVisibility(View.VISIBLE);
                txtTitle.setText(pTitle);
            }

            txtContent.setText(pContent);

            dialog.setCancelable(false);
            dialog.show();

            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    onClickFinishButton(pActivity, dialog);
                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickConfirmButton(dialog);
                }
            });
        }
    }


    private static void setDialogSize(Dialog dialog) {
        ViewGroup.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = Util.getDeviceWidth(dialog.getContext()) * 80 / 100;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    dialog.cancel();
                }
                return true;
            }
        });
    }

    private void onClickConfirmButton(DialogInterface pDialog) {
        pDialog.cancel();
    }

    public void setOnConfirmClickListener(OnConfirmClickListener onConfirmClickListener) {
        mOnConfirmClickListener = onConfirmClickListener;
    }

    public void setOnAlertClickListener(OnAlertClickListener onAlertClickListener) {
        mOnAlertClickListener = onAlertClickListener;
    }

    private void onClickFinishButton(Activity pActivity, DialogInterface pDialog) {
        pActivity.finish();
        pDialog.cancel();
    }
}

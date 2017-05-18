1. 自律
2. 专注
3. 高效
4. 勤奋
5. 热爱工作，学习




python 
swift 
java

js/css/html
ios
android

math
english

suanfa
ml





PubCarSuccessFragment
RecFindCarAdapter

item_pubcar_list


ShareDialog  dialog = ShareDialog.newInstance("test","testesttesttestt");
                    dialog.show(getSupportFragmentManager(),"test11");
                    dialog.setSharedClickListener(new ShareDialog.SharedClickListener() {
                        @Override
                        public void onCloseClicked(View view) {

                        }

                        @Override
                        public void onFriendClicked(View view) {
                            dialog.dismiss(); 
                             if (iShareToWeChart != null) {
                    iShareToWeChart.sharePlatformToFriend();
                }
                        }

                        @Override
                        public void onCircleClicked(View view) {
                            dialog.dismiss();
                            if (iShareToWeChart != null) {
                    			iShareToWeChart.sharePlatformToCircle();
                			}
                        }
                    });



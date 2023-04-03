//public class MainActivity extends AppCompatActivity {
//
//    TextView tv_score;
//    Button btn_start;
//    //이미지뷰 9개를 한번에 다룰 배열!
//    ImageView[] imgArray = new ImageView[9] ;
//    int cnt = 0;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        tv_score = findViewById(R.id.tv_score);
//        btn_start = findViewById(R.id.btn_start);
//
//        for(int i=0;i<imgArray.length;i++){
//            //아이디 값의 타입???
//            //img1 ~ img9까의 대한 ID 값이 imgId 에 담기게 된다!!
//            int imgId = getResources().getIdentifier("img"+(i+1),"id",getPackageName());
//            imgArray[i] = findViewById(imgId);
//            imgArray[i].setTag("off");
//
//            imgArray[i].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    // View 객체는 화면에 보여지는 모든 요소에대한 제일 최상위 객체이다!
//                    // view 를 통해서 사용해 줄때는 다운캐스팅 해서 사용해 줘야 한다!
//                    ImageView img = (ImageView) view;
//
//                    if(img.getTag().equals("on")){
//                        //내려가있는 이미지로 바꾸어주세요!
//                        img.setImageResource(R.drawable.off);
//                        cnt++;
//                        tv_score.setText("SCORE : "+cnt);
//                        img.setTag("off");
//                    }
//
//                }
//            });
//
//        }
//        // btn_start, tv_score, imgArray 준비 완료!
//
//        //1. 버튼을 클릭했을때 이미지가 랜덤시간이 지난뒤 올라온이미지로 바뀌게 해주세요!
//        //2. 이미지를 클릭 했을때 내려간 이미지로 만들기
//
//        //3. 이미지를 클릭했다면 다면 SCORE 값이 1증가
//        //4. 올라온 이미지를 클릭했을때만 SCORE 값이 1 증가
//        //(현재 이미지가 내려가있는 이미지인지 올라와 있는 이미지 인지 판별 해줘야함!)
//
//        //5. 계속 반복 되게 이미지 변경 될 수 있도록
//        //6. cnt 값이 30이라면 이제 그만
//        btn_start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                for(int i=0; i<imgArray.length;i++){
//                    DoThread thread = new DoThread(i);
//                    thread.start();//★★★★★
//                }
//            }
//        });
//    }
//
//    Handler doHandler = new Handler(){
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            //이미지뷰를 바꾸어줄게요!!!
//
//            imgArray[msg.arg1].setImageResource(msg.arg2);
//
//            imgArray[msg.arg1].setTag(msg.obj.toString());
//        }
//    };
//
//    //각각의 이미지가 랜덤한 시간을 셀수 있도록 도와주는 쓰레드
//    class DoThread extends Thread{
//        //몇번째 이미지인지?
//        int pos;
//
//        public DoThread(int pos){
//            this.pos = pos;
//        }
//
//        @Override
//        public void run() {
//
//            Random ran = new Random();
//            //1~9사이의 랜덤값
//            int ranTime = ran.nextInt(9)+1;//1~9
//
//            //랜덤한 시간을 기다려주세요!
//            try {
//                while(true){
//                    if(cnt>=30){
//                        break;
//                    }
//                    Thread.sleep(ranTime*1000);
//                    //이미지를 올라온 이미지로 바꾸어주세요! -> 쓰레드 라서 이미지뷰를 조작 할수 없다
//                    //--> handler로 요청을 보내야한다!!
//                    //요청 데이터  1. 몇번째 이미지인지  2. 어떤 이미지로 바꿀지
//
//                    if(imgArray[pos].getTag().equals("off")){
//                        Message msg = new Message();
//                        msg.arg1 = pos;
//                        msg.arg2 = R.drawable.on;
//                        msg.obj="on";
//                        doHandler.sendMessage(msg);
//                    }else{
//                        Message msg = new Message();
//                        msg.arg1 = pos;
//                        msg.arg2 = R.drawable.off;
//                        msg.obj ="off";
//                        doHandler.sendMessage(msg);
//                    }
//
//
//                }
//
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
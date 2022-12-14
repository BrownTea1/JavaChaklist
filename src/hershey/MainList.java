package hershey;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;


public class MainList extends JFrame{
	
	private final static int LIST_SIZE = 5;
	private	int textCount;
	 int comVecCount=0;
	public MainList() {
		Vector <String> checkVec = new Vector<String>(5);
		Vector<String> comVec = new Vector<String>();
		setSize(500, 500);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MainList");
        
        Container con = getContentPane();
 
    	
    	
    	
        //패널 객체모음
        JPanel listPanel = new JPanel();
        JPanel listcomPanel = new JPanel();
        JPanel tflistPanel = new JPanel();
        
        JPanel[] listcheckPanel = new JPanel[LIST_SIZE];
        JPanel[] listcheckcomPanel = new JPanel[LIST_SIZE];
       
        //GridBag 각 패널로 선언 
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbclistcheck = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();
        GridBagLayout listgrid = new GridBagLayout();
        GridBagLayout listcomGrid = new GridBagLayout();
        
        //이미지 객체
        ImageIcon addImage1 = new ImageIcon("./ButtonImage/listPlus.png");
        ImageIcon emptyStar = new ImageIcon("./ButtonImage/emptyStar.png");
        ImageIcon fillStar  = new ImageIcon("./ButtonImage/fillStar.png");
        ImageIcon circleChack = new ImageIcon("./ButtonImage/circleChack.png");
        
        //buttons 객체 
        JButton addlistButton = new JButton(addImage1);
    	JButton[] starButton = new JButton[10];
    	JButton[] circleCheckButton = new JButton[10];
    	
    	
       //bool 
    	boolean[] boolStar = new boolean[10];
        //addlistButton.setRolloverIcon(addImg);
        addlistButton.setPreferredSize(new Dimension(30,30));
       
       
        setLayout(gbl);
        //텍스트 입력창
        JTextField tflistInput = new JTextField(10);

        //라벨 리스트
        JLabel[] labelChecklist = new JLabel[10];
        JLabel[] labelComlist = new JLabel[10];
        //할 일 라벨 리스트 생성 및 별버튼생성
        for(int i=0;i<labelChecklist.length;i++) 
        {labelChecklist[i] = new JLabel("CheckNULL");
        labelChecklist[i].setHorizontalAlignment(SwingConstants.CENTER);
        starButton[i] = new JButton(emptyStar);
        starButton[i].setPreferredSize(new Dimension(40,40));
        circleCheckButton[i] = new JButton(circleChack);
        circleCheckButton[i].setPreferredSize(new Dimension(40,40));
        circleCheckButton[i].setBorderPainted(false);
        circleCheckButton[i].setOpaque(false);
        circleCheckButton[i].setFocusPainted(false);
        }
        
        //완료된 라벨 리스트 생성 
        for(int i=0;i<labelComlist.length;i++)
        {labelComlist[i] = new JLabel("ComNULL");
        
       
        }
        
        /*
		 * for(JLabel labelarray : labelChecklist)
		 *  { labelarray = new JLabel("NULL"); }
		 */
        
      //할일 + 완료 라벨 리스트 폰트 설정
        for(int i=0; i<labelChecklist.length;i++) {
        //checklist
        	labelChecklist[i].setFont(new Font("verdana",1,15));
        	labelComlist[i].setFont(new Font("verdana",1,15));
        	
        }
        //...............//
        
        //컬러 정의
        Color colorblue = new Color(0x69bc2e6);
        Color backgroundColor = new Color(0x91E0EEFA);
        Color tfColorblue = new Color(0x79C4D5E6);
        
        //뒷배경 색깔(패널,텍스트)
        listcomPanel.setBackground(backgroundColor);
        tflistPanel.setBackground(tfColorblue);
        tflistInput.setBackground(tfColorblue);
       
        
        //테두리선 정의
        LineBorder lineBorderblack = new LineBorder(backgroundColor,10,true);
        LineBorder comLineBordergreen = new LineBorder(backgroundColor,10,true);
        LineBorder tflineBorderyello = new LineBorder(tfColorblue,10,true);
        LineBorder listcheckBorderblue = new LineBorder(backgroundColor,1);
        //...............//
        
        //각 패널에 테두리 프로퍼티 선언
        listPanel.setBorder(lineBorderblack);
        listcomPanel.setBorder(comLineBordergreen);
        tflistPanel.setBorder(tflineBorderyello);
        

        //...............//
        
        //리스트패널 체크 2개 선언
        
        gbclistcheck.fill = GridBagConstraints.BOTH;
        gbclistcheck.weightx = 1;
        gbclistcheck.weighty = 1;
        gbclistcheck.gridheight = 1;
        gbclistcheck.gridwidth = 10;
       
        //...............//
        
      //gbc 각 컴포넌트 선언
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 10;
        gbc.weighty = 10;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        
        //...............//
        
        //작업패널안에 텍스트필드 프로퍼티 선언
        tflistPanel.setLayout(new BorderLayout());
        tflistPanel.add(addlistButton,BorderLayout.WEST);
        tflistPanel.add(tflistInput,BorderLayout.CENTER);;
        con.add(tflistPanel);
               
        //...............//
        
        //리스트 패널 추가
        add(listPanel,gbc);
        listPanel.setLayout(listgrid);
		for(int i=0;i<listcheckPanel.length;i++) {
			listcheckPanel[i] = new JPanel();	
			listcheckPanel[i].setBorder(listcheckBorderblue);
			listcheckPanel[i].setBackground(Color.white);
			gbclistcheck.gridy =i+1; 
			
			listPanel.add(listcheckPanel[i],gbclistcheck);	
			listcheckPanel[i].setLayout(new BorderLayout());
			listcheckPanel[i].add(labelChecklist[i],BorderLayout.CENTER);
			listcheckPanel[i].add(starButton[i],BorderLayout.EAST);
			listcheckPanel[i].add(circleCheckButton[i],BorderLayout.WEST);
		}	
		
        //...............//
		//완성텍스트패널 
		gbc.gridy = 2;
		//...............//
        //완성패널 추가
        gbc.gridy = 3;
        
        add(listcomPanel,gbc);
        listcomPanel.setLayout(listcomGrid);
        
      	for(int j=0; j<listcheckcomPanel.length;j++){
      		listcheckcomPanel[j]= new JPanel();
      		listcheckcomPanel[j].setBorder(listcheckBorderblue);
      		listcheckcomPanel[j].setBackground(colorblue);
  			gbclistcheck.gridy =j+1; 
  			
  			listcomPanel.add(listcheckcomPanel[j],gbclistcheck);
  			listcheckcomPanel[j].add(labelComlist[j]);
      		}
      	
      	
      	
      	
        //...............//
        //작업추가 텍스트필드
        gbc.weighty = 0.1;
        gbc.gridy=4;
        add(tflistPanel,gbc);
        
      //...............//
       //텍스터필드 <Enter>및 버튼
    
        tflistInput.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        		//labelChecklist[textCount].setText(tflistInput.getText());
        		checkVec.add(tflistInput.getText());
        		labelChecklist[textCount].setText(checkVec.get(textCount)); 
        		
        		textCount++;
        		 if(textCount >4)textCount=0;
        		 
        		 tflistInput.setText("");
        	}
        });
        
        
        addlistButton.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		labelChecklist[textCount].setText(tflistInput.getText());
        		textCount++;
        		 if(textCount >4) {textCount = 0;}
        		 tflistInput.setText("");
        }});
       
        circleCheckButton[0].addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		comVec.add(checkVec.get(0));
        		checkVec.remove(0);
        		labelComlist[checkVec.size()].setText(comVec.get(comVecCount));
        		comVecCount++;
        		for(int i=0;i<=checkVec.size();i++) {
        			labelChecklist[i].setText(checkVec.get(i));
        			if(checkVec.size() < checkVec.capacity()) {
        				labelChecklist[checkVec.size()].setText("");
        			} 
        		}
        }});
        
        circleCheckButton[1].addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		comVec.add(checkVec.get(1));
        		checkVec.remove(1);
        		labelComlist[checkVec.size()].setText(comVec.get(comVecCount));
        		comVecCount++;
        		for(int i=0;i<=checkVec.size();i++) {
        			labelChecklist[i].setText(checkVec.get(i));
        			if(checkVec.size() < checkVec.capacity()) {
        				labelChecklist[checkVec.size()].setText("");
        			} 
        		}
        }});
        
        circleCheckButton[2].addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		comVec.add(checkVec.get(2));
        		checkVec.remove(2);
        		labelComlist[checkVec.size()].setText(comVec.get(comVecCount));
        		comVecCount++;
        		for(int i=0;i<=checkVec.size();i++) {
        			labelChecklist[i].setText(checkVec.get(i));
        			if(checkVec.size() < checkVec.capacity()) {
        				labelChecklist[checkVec.size()].setText("");
        			} 
        		}
        }});
        
        circleCheckButton[3].addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		comVec.add(checkVec.get(3));
        		checkVec.remove(3);
        		labelComlist[checkVec.size()].setText(comVec.get(comVecCount));
        		comVecCount++;
        		for(int i=0;i<=checkVec.size();i++) {
        			labelChecklist[i].setText(checkVec.get(i));
        			if(checkVec.size() < checkVec.capacity()) {
        				labelChecklist[checkVec.size()].setText("");
        			} 
        		}
        }});
        
        circleCheckButton[4].addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		comVec.add(checkVec.get(4));
        		checkVec.remove(4);
        		labelComlist[checkVec.size()].setText(comVec.get(comVecCount));
        		comVecCount++;
        		for(int i=0;i<=checkVec.size();i++) {
        			labelChecklist[i].setText(checkVec.get(i));
        			if(checkVec.size() < checkVec.capacity()) {
        				labelChecklist[checkVec.size()].setText("");
        			} 
        		}
        }});
        
        for(int i=0;i<5;i++) {
        	boolStar[i] = false;
        starButton[i].addActionListener(new ActionListener() {
        		@Override
        		public void actionPerformed(ActionEvent e) {
        			
        		}});}
        
       
        starButton[0].addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if( boolStar[0] == false) {
    				starButton[0].setIcon(fillStar); 	boolStar[0] = true;
    			}else{starButton[0].setIcon(emptyStar); boolStar[0] = false;}
    		}});
        starButton[1].addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if( boolStar[1] == false) {
    				starButton[1].setIcon(fillStar);	boolStar[1] = true;
    			}else{starButton[1].setIcon(emptyStar); boolStar[1] = false;}
    		}});
        starButton[2].addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if( boolStar[2] == false) {
    				starButton[2].setIcon(fillStar);	boolStar[2] = true;
    			}else{starButton[2].setIcon(emptyStar); boolStar[2] = false;}
    		}});
        starButton[3].addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if( boolStar[3] == false) {
    				starButton[3].setIcon(fillStar);	boolStar[3] = true;
    			}else{starButton[3].setIcon(emptyStar); boolStar[3] = false;}
    		}});
        starButton[4].addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if( boolStar[4] == false) {
    				starButton[4].setIcon(fillStar);	boolStar[4] = true;
    			}else{starButton[4].setIcon(emptyStar); boolStar[4] = false;}
    		}});
        
        
		/*
		 * //star 버튼액션 ActionListener[] starListener = new ActionListener[i] {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { if(star == false) {
		 * starButton[0].setIcon(fillStar); star = true; }else if(star == true) {
		 * starButton[0].setIcon(emptyStar); star = false; } }};
		 * starButton[0].addActionListener(starListener);
		 */
       
       
        setLocationRelativeTo(null);
        setVisible(true);
 }

	public static void main(String[]args) {
		new MainList();
}
}

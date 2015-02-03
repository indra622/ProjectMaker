package csee.narasarang.projmaker.file;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
         
public class Attachment extends JFrame {
       
       
		private JFileChooser jfc = new JFileChooser();
		public static String path;
		public File openfile;
		
        public Attachment(){     
                this.start();
                if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                    // showopendialog 열기 창을 열고 확인 버튼을 눌렀는지 확인
                	path=jfc.getSelectedFile().toString();
                }
                openfile = new File(path);
                
        }
      
        public void start(){
              
                jfc.setFileFilter(new FileNameExtensionFilter("txt", "txt"));
                // 파일 필터
                jfc.setMultiSelectionEnabled(false);//다중 선택 불가
        }
        
     public static String openpath () {
    	 return path;
     }
       
 }



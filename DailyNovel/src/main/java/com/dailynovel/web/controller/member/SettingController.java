package com.dailynovel.web.controller.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

//import com.aspose.words.Document;
import com.dailynovel.web.entity.Export;
import com.dailynovel.web.entity.Setting;
import com.dailynovel.web.entity.setFont;
import com.dailynovel.web.service.SettingService;
import com.dailynovel.web.service.파일없음예외;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/member/setting/")
public class  SettingController {

	@Autowired
	private SettingService settingService;
	
	private String imageName;
	private Integer id;
	public SettingController() {
		id=1;
	}
	
	@RequestMapping("main")
	public String main(){
		return "/member/settings/main";
	}

		// 세팅-프로필-------------------------------------------------------------------
		@RequestMapping("profile")
		public String profile(Model model) {
	        
			//Integer id = 1;
			Setting setting = settingService.getById(id); // id 1번의 member테이블의 값 가지고 오기
			model.addAttribute("setting", setting);		// 가지고 온 테이블 값을 model에 심기
			System.out.println(setting);				// 삭제요망 제대로 가지고 왔는지 확인차 출력해 보기 삭제요망
			imageName = setting.getProfileImage();		// 가지고 온 profile이미지의 명칭을 전역변수에 넣기
			System.out.println(imageName);
			return "member/settings/component/profile";
		}

		@PostMapping("profile/update")
		public String profileUpdate(Model model,
				// MultipartFile profileIma,
				@RequestPart(name = "image") MultipartFile profile, 
				@RequestParam("name") String Nickname,
				@RequestParam("stsMessage") String stsMessage, 
				@ModelAttribute Setting setting, 
				HttpServletRequest request
				) throws Exception {
			
			// 전에 등록한 프로필 사진 사진파일 삭제하는 코드?
			String beforeImagePath = System.getProperty("user.home"); // 컴퓨터의 사용자 경로 추출 
// 노트북 경로 Path filePath = Paths.get( beforeImagePath + "/Desktop/proproprj/DailyNovel/src/main/webapp/img/profile/" + imageName);
/*데스크톱경로*/Path filePath = Paths.get( beforeImagePath + "/Desktop/novelPrj(2)/nav/DailyNovel/src/main/webapp/img/profile/" + imageName); 
			
			try {
				// 삭제하는 클래스 생성(사실상 서비스를 호출) service.deleteImage(filePath);
				// 서비스에 deleteImage매소드를 만들고, 그 안에서 filePath에 해당 이미지 파일잉 없으면 출력할 예외만들기 'throw new 사진없음예외();'
				settingService.deleteBeforeImage(filePath);
				if(!imageName.equals("pro-img.png"))
					Files.delete(filePath);				
			}
			catch(파일없음예외 e){
				System.out.println(e.getMessage());
			}
			

			
			String realPath= "";
			if (profile != null && !profile.isEmpty()) { // 사용자가 새로운 이미지를 등록 했을 때만 실행하기
				Date date = new Date(System.currentTimeMillis()); // 현재 시간 측정
				SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd-HH-mm-ss-SS"); // 시간 측정 포멧 지정
				String time = format.format(date); // 측정한 시간을 포멧화 하기
				MultipartFile img = profile; // input된 이미지를 파일에 넣기
				String profileImage = time + "__" + img.getOriginalFilename(); // 이미지 파일의 이름을 추출

				String urlPath = "/img/profile/" + profileImage; // 업로드할 파일이 저장될 경로
				realPath = request.getServletContext().getRealPath(urlPath); // 실제 파일 경로

				byte[] buf = new byte[1024];
				InputStream fis = img.getInputStream();
				int size = 1024;
				FileOutputStream fos = new FileOutputStream(realPath);
	 
				while ((size = fis.read(buf)) != -1) {
					fos.write(buf, 0, size);
				}
				fis.close();
				fos.close();
				setting.setProfileImage(profileImage);
			}
			//Integer id = 1;
			setting.setId(id);
			setting.setNickName(Nickname);
			setting.setStatusMessage(stsMessage);
			int a = settingService.updateProfile(setting);
			
			if(setting.getProfileImage()!=null) {  // 사진의 업데이트가 있으면 5초 지연
				Thread.sleep(5000);
				return "redirect:../profile";
			}
			else								   // 사진의 업데이트가 없으면 바로 전송(상태메시지 수정만 있는 경우
				return "redirect:../profile";
			
		}

		// 세팅-폰트-------------------------------------------------------------------
		@RequestMapping("/font")
		public String font(Model model, Model model2) {

			Setting setting = settingService.getById(id);
			
			List<setFont> font = settingService.getByFontId();
			
			model2.addAttribute("setting", setting);
			model.addAttribute("font", font);
			System.out.printf("폰트패밀리 %s\n",setting.getFontFamily());
			System.out.printf("폰트사이즈 %s\n",setting.getFontSize());

			return "member/settings/component/font";
		}
		
		@RequestMapping("/font/update")
		public String fontUpdate(Model model,
				@RequestParam(name = "font", required = false) String font,
				@RequestParam(name = "fontSize", required = false) int fontSize,
				@ModelAttribute Setting setting
				) {
			//Integer id = 1;
			
			setting.setId(id);
			setting.setFontFamily((font));
			setting.setFontSize((fontSize==16 ? "1" : fontSize==22?"2":"3"));
			System.out.println(setting);
			
			int a = settingService.updateFont(setting);

				return "redirect:../font";
		}

		// 세팅-알람-------------------------------------------------------------------
		@RequestMapping("/alarm")
		public String alarm(Model model) {
			
			//Integer id = 1;
			Setting setting = settingService.getById(id);
			model.addAttribute("setting", setting);
			System.out.println(setting);
			return "member/settings/component/alarm";
		}

		@PostMapping("/alarm/update")
		public String alarm(Model model, 
				@RequestParam(name = "web-alarm", required = false) String alarmSwitch,
				@RequestParam(name = "katolk-alarm", required = false) String kakaoAlarmSwitch,
				@RequestParam(name = "timer") String alarmTime, 
				@ModelAttribute Setting setting) {
			
			//Integer id = 1;
			setting.setId(id);
			setting.setAlarmSwitch((alarmSwitch == null ? "0" : "1"));
			setting.setKakaoAlarmSwitch((kakaoAlarmSwitch == null ? "0" : "1"));
			setting.setAlarmTime(alarmTime);

			System.out.println(setting);
			int a = settingService.updateProfile(setting);

			if (a == 1)
				return "redirect:../alarm";
			else
				return "ㅋㅋ";
		}

		// 세팅-내보내기-------------------------------------------------------------------
		@RequestMapping("/export")
		public String export(Model model) throws UnknownHostException {
			
			//Integer id = 1;
			Setting setting = settingService.getById(id);
			model.addAttribute("setting", setting);
			System.out.println(setting);
			return "member/settings/component/export";
		}

		@RequestMapping("/export/text")
		public void exportText(Model model, HttpServletResponse response) throws Exception {
			
			//Integer id = 1;
			List<Export> export = settingService.getDiaryListByid(id);
			
			// 1) com.lowagie.text.Document 클래스 인스턴스를 생성합니다.
		Document document = new Document();
		Date makingTime = new Date(System.currentTimeMillis()); // 현재 시간 측정
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd-HH-mm-ss-SS"); // 시간 측정 포멧 지정
		String time = format.format(makingTime); // 측정한 시간을 포멧화 하기
		File file = new File(time+"DailyNovel.PDF");
		
		try {
			// 2) Writer와 Document 사이의 연관을 맺어줍니다.
			PdfWriter.getInstance(document, new FileOutputStream(file));	
			
			// 3)  문서를 오픈합니다.
			document.open();
			
			// 4) 한글 입력을 위해 폰트를 선택해줍니다. iTextAsian.jar에서는 다음 3개의 폰트를 사용할 수 있습니다.
			// HYGoThic-Medium, HYSMyeongJo-Medium, HYSMyeongJoStd-Medium
			String fontFace = "HYGoThic-Medium";
			
			// 5) 글자 방향을 결정하는 CMap은 두가지가 있습니다. 
			// UniKS-UCS2-H : 가로, UniKS-UCS2-V : 세로
			String fontNameH = "UniKS-UCS2-H";

			// 6) 준비한 설정값들을 활용해 Font 객체를 생성해줍니다. 생성자에 들어가는 인자는 BaseFont 와 사이즈 입니다.
			BaseFont bf = BaseFont.createFont(fontFace, fontNameH, BaseFont.NOT_EMBEDDED);
			Font font = new Font(bf, 11);
			
			// 7) 문서에 2개의 paragraph를 각기 다른 본트로 첨부해 보겠습니다.		
			for (Export aa : export) {
				//out.print(aa.getRegDate());
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String date = formatter.format(aa.getRegDate());
				document.add(new Paragraph(date+" "+"  "+"["+aa.getFeelingName()+"]", font));
				//document.add(new Paragraph("["+aa.getFeelingName()+"]", font));
				document.add(new Paragraph("제목: "+aa.getTitle(), font));
				document.add(new Paragraph("\n", font));
				document.add(new Paragraph(aa.getText(), font));
				document.add(new Paragraph("\n", font));
				document.add(new Paragraph("\n", font));
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			document.close();	
		}
		
		 // 바탕화면으로 전송
			String path = time + "DailyNovel.PDF";
				
				
			FileInputStream fis = new FileInputStream(path);
			byte buf[] = new byte[1024];

			int size = 1024;
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(time + "DailyNovel.PDF", "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			while ((size = fis.read(buf)) != -1) {
				response.getOutputStream().write(buf, 0, size);
			}
			response.getOutputStream().flush();
			response.getOutputStream().close();

			fis.close();

			// 지연시간

			try {
			// 바탕화면 삭제
				Path testPdf = Paths.get(time + "DailyNovel.PDF");

				Files.delete(testPdf);
				
				// 디렉토리 삭제
//		            Files.delete(directoryPath);

			} catch (NoSuchFileException e) {
				System.out.println("삭제하려는 파일/디렉토리가 없습니다");
			} catch (DirectoryNotEmptyException e) {
				System.out.println("디렉토리가 비어있지 않습니다");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		
		// 8) Chrome 으로 방금 작성한 파일을 바로 열어서 확인해봅니다.
//		String chrome = "C:/Program Files/Google/Chrome/Application/chrome.exe";
//		try {
//			new ProcessBuilder(chrome,file.getAbsolutePath()).start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
			
//			Date date = new Date(System.currentTimeMillis()); // 현재 시간 측정
//			SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd-HH-mm-ss-SS"); // 시간 측정 포멧 지정
//			String time = format.format(date); // 측정한 시간을 포멧화 하기
//
//		// 바탕화면으로 경로 만들기 테스트
//			String deskTopPath = System.getProperty("user.home");
//			String filePath = deskTopPath + "/Desktop/" + time + "dailyNovel.txt";
//
//			FileOutputStream fos = new FileOutputStream(filePath);
//			PrintStream out = new PrintStream(fos);
//
//			for (Export aa : export) {
//				out.print(aa.getRegDate());
//				out.print(" [ ");
//				out.print(aa.getFeelingName());
//				out.print(" ] ");
//				out.println();
//				out.printf("제목: %s", aa.getTitle());
//				out.println();
//				out.print(aa.getText());
//				out.println();
//				out.println();
//			}
//			fos.close();
//			// 지연시간
//
//			// TXT 파일 로드
//			Document document = new Document(filePath);
//
//		// 바탕화면으로 TXT 파일을 PDF로 저장
//			document.save( deskTopPath + "/Desktop/" + time + "output.pdf");
//			
//
//		 // 바탕화면으로 전송
//			String path = deskTopPath + "/Desktop/" + time + "output.pdf";
//				
//				
//			FileInputStream fis = new FileInputStream(path);
//			byte buf[] = new byte[1024];
//
//			int size = 1024;
//			response.setContentType("application/octet-stream");
//			response.setHeader("Content-Disposition",
//					"attachment; fileName=\"" + URLEncoder.encode(time + "output.pdf", "UTF-8") + "\";");
//			response.setHeader("Content-Transfer-Encoding", "binary");
//			while ((size = fis.read(buf)) != -1) {
//				response.getOutputStream().write(buf, 0, size);
//			}
//			response.getOutputStream().flush();
//			response.getOutputStream().close();
//
//			fis.close();
//
//			// 지연시간
//
//			try {
//				// 파일 삭제
//				// 삭제
//			// 바탕화면 삭제
//				Path testPdf = Paths.get( deskTopPath + "/Desktop/" + time + "output.pdf");
//
//				Files.delete(testPdf);
//					Path testText = Paths.get(deskTopPath + "/Desktop/" + time + "dailyNovel.txt");
//				
//				Files.delete(testText);
//				// 디렉토리 삭제
////		            Files.delete(directoryPath);
//
//			} catch (NoSuchFileException e) {
//				System.out.println("삭제하려는 파일/디렉토리가 없습니다");
//			} catch (DirectoryNotEmptyException e) {
//				System.out.println("디렉토리가 비어있지 않습니다");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}

		// 세팅-피드백-------------------------------------------------------------------
		@RequestMapping("/service-help")
		public String serviceHelp(Model model) {

			//Integer id = 1;
			Setting setting = settingService.getById(id);
			model.addAttribute("setting", setting);
			return "member/settings/component/service-help";
		}

		// 세팅-로그아웃-------------------------------------------------------------------
		@RequestMapping("/out")
		public String out() {
			
			Integer id = 39;
			Setting setting = settingService.getById(id);
			System.out.println(setting);
			
			return "member/settings/component/out";
		}

		@PostMapping("/out/update")
		public String acountOut(Model model, 
				@ModelAttribute Setting setting) {

			Integer id = 39;
			setting.setId(id);

			int a = settingService.deleteAcount(id);
			System.out.println(a);
//			return "member/settings/main";
			if (a == 1)
				return "redirect:../../../";
				//return "redirect:../alarm";
			else
				return "redirect:../../setting/out";
		}
	
}

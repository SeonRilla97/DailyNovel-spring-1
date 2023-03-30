package com.dailynovel.web.controller.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

import com.aspose.words.Document;
import com.dailynovel.web.entity.Export;
import com.dailynovel.web.entity.Setting;
import com.dailynovel.web.service.SettingService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/member/setting/")
public class  SettingController {

	
	
	@Autowired
	private SettingService settingService;
	
	@RequestMapping("main")
	public String main(){
		return "/member/settings/main";
	}


		// 세팅-프로필-------------------------------------------------------------------
		@RequestMapping("profile")
		public String profile(Model model) {

			Setting setting = settingService.getById(1);
			// Setting setting = settingService.update();
			model.addAttribute("setting", setting);
			System.out.println(setting);
			return "member/settings/component/profile";
		}

		@PostMapping("profile/update")
		public String profileUpdate(Model model,
				// MultipartFile profileIma,
				@RequestPart(name = "image") MultipartFile profile, @RequestParam("name") String Nickname,
				@RequestParam("stsMessage") String stsMessage, @ModelAttribute Setting setting, HttpServletRequest request)
				throws Exception {
			Integer id = 1;
			String realPath= "";
			if (profile != null && !profile.isEmpty()) { // 이미지가 비어있지 않을 때만 실행시키기
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
			setting.setId(id);
			setting.setNickName(Nickname);
			setting.setStatusMessage(stsMessage);
			int a = settingService.updateProfile(setting);
			
			return "redirect:../profile";
			
		}

		// 세팅-폰트-------------------------------------------------------------------
		@RequestMapping("/font")
		public String font(Model model) {

			Setting setting = settingService.getById(2);
			model.addAttribute("setting", setting);
			System.out.println(setting);
			return "member/settings/component/font";
		}

		// 세팅-알람-------------------------------------------------------------------
		@RequestMapping("/alarm")
		public String alarm(Model model) {

			Setting setting = settingService.getById(2);
			model.addAttribute("setting", setting);
			System.out.println(setting);
			return "member/settings/component/alarm";
		}

		@PostMapping("/alarm/update")
		public String alarm(Model model, @RequestParam(name = "web-alarm", required = false) String alarmSwitch,
				@RequestParam(name = "katolk-alarm", required = false) String kakaoAlarmSwitch,
				@RequestParam(name = "timer") String alarmTime, @ModelAttribute Setting setting) {

			setting.setId(2);
			setting.setAlarmSwitch((alarmSwitch == null ? "0" : "1"));
			setting.setKakaoAlarmSwitch((kakaoAlarmSwitch == null ? "0" : "1"));
			setting.setAlarmTime(alarmTime);

			System.out.println(setting);
			int a = settingService.updateProfile(setting);

			if (a == 1)
				return "redirect:../alarm";
			// return "redirect:../../main";
			else
				return "ㅋㅋ";
		}

		// 세팅-내보내기-------------------------------------------------------------------
		@RequestMapping("/export")
		public String export(Model model) {

			Setting setting = settingService.getById(2);
			model.addAttribute("setting", setting);
			System.out.println(setting);
			return "member/settings/component/export";
		}

		@RequestMapping("/export/text")
		public void exportText(Model model, HttpServletResponse response) throws Exception {

			List<Export> export = settingService.getDiaryListByid(1);
			// C:\Users\BW3\Desktop\down
//			String homeDir = System.getProperty("user.home");
//			System.out.println(homeDir);
//			String filePath = "text/dailynovel.txt";

			Date date = new Date(System.currentTimeMillis()); // 현재 시간 측정
			SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd-HH-mm-ss-SS"); // 시간 측정 포멧 지정
			String time = format.format(date); // 측정한 시간을 포멧화 하기

			String filePath = "C:/Users/BW3/Desktop/novelPrj/prj0327/DailyNovel/src/main/resources/static/text/" + time
					+ "dailyNovel.txt";

			FileOutputStream fos = new FileOutputStream(filePath);
			PrintStream out = new PrintStream(fos);

			for (Export aa : export) {
				out.print(aa.getRegDate());
				out.print(" [ ");
				out.print(aa.getFeelingName());
				out.print(" ] ");
				out.println();
				out.printf("제목: %s", aa.getTitle());
				out.println();
				out.print(aa.getText());
				out.println();
				out.println();
			}
			fos.close();
			// 지연시간

			// TXT 파일 로드
			Document document = new Document(filePath);

			// TXT 파일을 PDF로 저장
			document.save("C:/Users/BW3/Desktop/novelPrj/prj0327/DailyNovel/src/main/resources/static/text/" + time
					+ "output.pdf");

			// 전송
			String path = "C:/Users/BW3/Desktop/novelPrj/prj0327/DailyNovel/src/main/resources/static/text/" + time
					+ "output.pdf";
			FileInputStream fis = new FileInputStream(path);
			byte buf[] = new byte[1024];

//		      char[] charbuf = new char[1024];

			int size = 1024;
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(time + "output.pdf", "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			while ((size = fis.read(buf)) != -1) {
				response.getOutputStream().write(buf, 0, size);
			}
			response.getOutputStream().flush();
			response.getOutputStream().close();

			fis.close();

			// 지연시간
//		      try {

			try {
				// 파일 삭제
				// 삭제
				Path testPdf = Paths.get("C:/Users/BW3/Desktop/novelPrj/prj0327/DailyNovel/src/main/resources/static/text/"
						+ time + "output.pdf");
				// String deletePath =
				// "C:/Users/BW3/Desktop/novelPrj/prj0327/DailyNovel/src/main/resources/static/text/"+
				// time +"dailyNovel.txt";
				// String testPdf =
				// "C:/Users/BW3/Desktop/novelPrj/prj0327/DailyNovel/src/main/resources/static/text/"+
				// time +"output.pdf";

				Files.delete(testPdf);
				Path testText = Paths.get("C:/Users/BW3/Desktop/novelPrj/prj0327/DailyNovel/src/main/resources/static/text/"
						+ time + "dailyNovel.txt");
				Files.delete(testText);
				// 디렉토리 삭제
//		            Files.delete(directoryPath);

			} catch (NoSuchFileException e) {

				System.out.println("삭제하려는 파일/디렉토리가 없습니다");
			} catch (DirectoryNotEmptyException e) {
				System.out.println("디렉토리가 비어있지 않습니다");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 세팅-피드백-------------------------------------------------------------------
		@RequestMapping("/service-help")
		public String serviceHelp(Model model) {

			Setting setting = settingService.getById(2);
			model.addAttribute("setting", setting);
			System.out.println(setting);
			return "member/settings/component/service-help";
		}

		// 세팅-로그아웃-------------------------------------------------------------------
		@RequestMapping("/out")
		public String out() {

			return "member/settings/component/out";
		}

		@PostMapping("setting/out/update")
		public String acountOut(Model model, @ModelAttribute Setting setting) {

			Integer id = 1;
			// setting.setId(id);

			int a = settingService.deleteAcount(id);

//			return "member/settings/main";
			if (a == 1)
				return "redirect:../../../";
			else
				return "redirect:../../setting/out";
		}
	
}

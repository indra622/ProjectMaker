package csee.narasarang.projmaker.factory;

import javax.swing.JFrame;
import javax.swing.JPanel;

import csee.narasarang.projmaker.UIcomponent.CreateMeetingPanel;
import csee.narasarang.projmaker.UIcomponent.CreateRoomPanel;
import csee.narasarang.projmaker.UIcomponent.CreateTaskPanel;
import csee.narasarang.projmaker.UIcomponent.SettingPanel;
import csee.narasarang.projmaker.UIcomponent.joinPanel;
import csee.narasarang.projmaker.UIcomponent.frame.PMFrame;

public class FrameFactory {
	public JFrame makeFrame(String name, JPanel panel) {
		switch (name) {
		case "MainFrame":
			return null;

		case "CreateRoomFrame":
			return new PMFrame((CreateRoomPanel) panel, 460, 400);

		case "CreateMeetingFrame":
			return new PMFrame((CreateMeetingPanel) panel, 400, 600);

		case "CreateTaskFrame":
			return new PMFrame((CreateTaskPanel) panel, 460, 400);

		case "SettingFrame":
			return new PMFrame((SettingPanel) panel, 460, 400);

		case "ProjectJoinFrame":
			return new PMFrame((joinPanel) panel, 300, 150);
		}
		return null;

	}
}

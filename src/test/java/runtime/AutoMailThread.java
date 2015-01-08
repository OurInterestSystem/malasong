package runtime;

import java.util.Calendar;

public class AutoMailThread implements Runnable {

	private String from;

	private String to;

	private String content;

	private Calendar calendar;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	private String getCalenderPrintable(Calendar cal) {
		return cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+":"
				+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
	}

	@Override
	public void run() {
		Calendar current = Calendar.getInstance();
		System.out.println("现在是: " + this.getCalenderPrintable(current));
		System.out.println("要等到: " + this.getCalenderPrintable(this.calendar));

		long diff = this.calendar.getTimeInMillis() - current.getTimeInMillis();
		if(diff > 0) {
			System.out.println("还有时间,睡觉去");
			try {
				Thread.sleep(diff);
				System.out.println("睡醒了,现在发送");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("搞错了吧，立马发送");
		}
	}

	public static void main(String[] args) {
		AutoMailThread autoMailThread = new AutoMailThread();

		Calendar cal = Calendar.getInstance();
		cal.set(2015, 0, 8, 23, 26, 10);//月份从0开始
		autoMailThread.setCalendar(cal);

		autoMailThread.setContent("hello");
		autoMailThread.setFrom("from");
		autoMailThread.setTo("to");
		autoMailThread.run();
	}

}

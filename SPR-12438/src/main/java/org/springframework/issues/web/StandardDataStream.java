package org.springframework.issues.web;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public final class StandardDataStream implements WriteListener {

	private final InputStream content;

	private final AsyncContext async;

	private final ServletOutputStream out;

	public StandardDataStream(InputStream content, AsyncContext async, ServletOutputStream out) {
		this.content = content;
		this.async = async;
		this.out = out;
	}

	public void onWritePossible() throws IOException {
		byte[] buffer = new byte[4096];

		// while we are able to write without blocking
		while (out.isReady()) {
			// read some content into the copy buffer
			int len = content.read(buffer);

			// If we are at EOF then complete
			if (len < 0) {
				async.complete();
				return;
			}

			// write out the copy buffer.
			out.write(buffer, 0, len);
		}
	}

	public void onError(Throwable t) {
		async.getRequest().getServletContext().log("Async Error", t);
		async.complete();
	}
}
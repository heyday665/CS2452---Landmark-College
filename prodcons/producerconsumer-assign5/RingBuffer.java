class RingBuffer {
	int nextp=0, nextc=0;
	byte[] pool = null;

	void produce(byte b) {
		pool[nextp++] = b;
		if (nextp == pool.length) nextp=0;
	}

	byte consume() {
		byte ret;
		ret = pool[nextc];
		nextc++;
		if (nextc == pool.length) nextc=0;
		return(ret);
	}

	RingBuffer(int sz) {
		pool = new byte[sz];
	}
}

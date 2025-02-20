public class BMPMessage {
    private final short magicNumber = (short) 0xABCD;
    private final byte version;
    private final byte type;
    private final byte[] body;

    public BMPMessage(byte version, byte type, byte[] body) {
        this.version = version;
        this.type = type;
        this.body = body;
    }

    public short getMagicNumber() {
        return magicNumber;
    }

    public byte getVersion() {
        return version;
    }

    public byte getType() {
        return type;
    }

    public byte[] getBody() {
        return body;
    }
}

package foundation.identity.did;

import foundation.identity.did.jsonld.DIDContexts;
import foundation.identity.did.jsonld.DIDKeywords;
import foundation.identity.jsonld.JsonLDObject;
import foundation.identity.jsonld.JsonLDUtils;

import java.io.Reader;
import java.net.URI;
import java.util.Map;

public class PublicKey extends JsonLDObject {

	public static final URI[] DEFAULT_JSONLD_CONTEXTS = { DIDContexts.JSONLD_CONTEXT_W3_NS_DID_V1 };
	public static final String[] DEFAULT_JSONLD_TYPES = { };
	public static final String DEFAULT_JSONLD_PREDICATE = DIDKeywords.JSONLD_TERM_PUBLICKEY;

	private PublicKey() {
		super(DIDContexts.DOCUMENT_LOADER);
	}

	public PublicKey(Map<String, Object> jsonObject) {
		super(DIDContexts.DOCUMENT_LOADER, jsonObject);
	}

	/*
	 * Factory methods
	 */

	public static class Builder extends JsonLDObject.Builder<Builder, PublicKey> {

		private String publicKeyBase64;
		private String publicKeyBase58;
		private String publicKeyHex;
		private String publicKeyPem;
		private Map<String, Object> publicKeyJwk;

		public Builder(PublicKey jsonLDObject) {
			super(jsonLDObject);
		}

		@Override
		public PublicKey build() {

			super.build();

			// add JSON-LD properties
			if (this.publicKeyBase64 != null) JsonLDUtils.jsonLdAdd(this.jsonLDObject, DIDKeywords.JSONLD_TERM_PUBLICKEYBASE64, this.publicKeyBase64);
			if (this.publicKeyBase58 != null) JsonLDUtils.jsonLdAdd(this.jsonLDObject, DIDKeywords.JSONLD_TERM_PUBLICKEYBASE58, this.publicKeyBase58);
			if (this.publicKeyHex != null) JsonLDUtils.jsonLdAdd(this.jsonLDObject, DIDKeywords.JSONLD_TERM_PUBLICKEYHEX, this.publicKeyHex);
			if (this.publicKeyPem != null) JsonLDUtils.jsonLdAdd(this.jsonLDObject, DIDKeywords.JSONLD_TERM_PUBLICKEYPEM, this.publicKeyPem);
			if (this.publicKeyJwk != null) JsonLDUtils.jsonLdAdd(this.jsonLDObject, DIDKeywords.JSONLD_TERM_PUBLICKEYJWK, this.publicKeyJwk);

			return this.jsonLDObject;
		}

		public Builder publicKeyBase64(String publicKeyBase64) {
			this.publicKeyBase64 = publicKeyBase64;
			return this;
		}

		public Builder publicKeyBase58(String publicKeyBase58) {
			this.publicKeyBase58 = publicKeyBase58;
			return this;
		}

		public Builder publicKeyHex(String publicKeyHex) {
			this.publicKeyHex = publicKeyHex;
			return this;
		}

		public Builder publicKeyPem(String publicKeyPem) {
			this.publicKeyPem = publicKeyPem;
			return this;
		}

		public Builder publicKeyJwk(Map<String, Object> publicKeyJwk) {
			this.publicKeyJwk = publicKeyJwk;
			return this;
		}
	}

	public static Builder builder() {
		return new Builder(new PublicKey());
	}

	/*
	 * Reading the JSON-LD object
	 */

	public static PublicKey fromJson(Reader reader) {
		return JsonLDObject.fromJson(PublicKey.class, reader);
	}

	public static PublicKey fromJson(String json) {
		return JsonLDObject.fromJson(PublicKey.class, json);
	}

	/*
	 * Adding, getting, and removing the JSON-LD object
	 */

	public static PublicKey getFromJsonLDObject(JsonLDObject jsonLdObject) {
		return JsonLDObject.getFromJsonLDObject(PublicKey.class, jsonLdObject);
	}

	public static void removeFromJsonLdObject(JsonLDObject jsonLdObject) {
		JsonLDObject.removeFromJsonLdObject(PublicKey.class, jsonLdObject);
	}

	/*
	 * Getters
	 */

	public String getPublicKeyBase64() {
		return JsonLDUtils.jsonLdGetString(this.getJsonObject(), DIDKeywords.JSONLD_TERM_PUBLICKEYBASE64);
	}

	public String getPublicKeyBase58() {
		return JsonLDUtils.jsonLdGetString(this.getJsonObject(), DIDKeywords.JSONLD_TERM_PUBLICKEYBASE58);
	}

	public String getPublicKeyHex() {
		return JsonLDUtils.jsonLdGetString(this.getJsonObject(), DIDKeywords.JSONLD_TERM_PUBLICKEYHEX);
	}

	public String getPublicKeyPem() {
		return JsonLDUtils.jsonLdGetString(this.getJsonObject(), DIDKeywords.JSONLD_TERM_PUBLICKEYPEM);
	}

	public Map<String, Object> getPublicKeyJwk() {
		return JsonLDUtils.jsonLdGetJsonObject(this.getJsonObject(), DIDKeywords.JSONLD_TERM_PUBLICKEYJWK);
	}
}
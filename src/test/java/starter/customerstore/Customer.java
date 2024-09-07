package starter.customerstore;

public class Customer {
  private int identityDocument;
  private String documentType;
  private String fullName;

  public int getIdentityDocument() {
    return identityDocument;
  }

  public void setIdentityDocument(int identityDocument) {
    this.identityDocument = identityDocument;
  }

  private String dateOfBirth;
  private Long id;



  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public Long getId() {
    return id;
  }

}

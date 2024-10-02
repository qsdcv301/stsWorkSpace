package taehyeon.ezen.book.util;

public class Paging {
   
	private int totalRecords;   
	private int recordsPerPage; 
	private int currentPage;
	private int totalPages; 
	private int pagesPerGroup; 
    private int currentGroup;
	
	public Paging(int totalRecords, int recordsPerPage, int currentPage, int pagesPerGroup) {
		this.totalRecords = totalRecords;
		this.recordsPerPage = recordsPerPage;
		this.currentPage = currentPage;
		this.pagesPerGroup = pagesPerGroup;
		this.totalPages = (int)Math.ceil((double) totalRecords / recordsPerPage);
		this.currentGroup = (int) Math.ceil((double)currentPage / pagesPerGroup); 
	}
   
	public int getStartPageOfGroup() {
		return (currentGroup - 1) * pagesPerGroup + 1;
	}
	
	public int getEndPageOfGroup() {
		int endPage = currentGroup * pagesPerGroup;
		return Math.min(endPage, totalPages);
	}
	
	public int getStartRecord() {
	   return (currentPage -1) * recordsPerPage;	
	}
	
	public int getTotalRecords() {
		return totalRecords;
	}
	
	public int getRecordsPerPage() {
		return recordsPerPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public int getPagesPerGroup() {
		return pagesPerGroup;
	}
}

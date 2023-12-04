XX.IntranetmainUserblock.txt

----------

Preference name: IntranetmainUserblock

Type: Textarea

Options: 70|10

----------

Preference value: 



<style type="text/css">
  .mptabContent *+* {
    margin-top: 1.1em;
    margin-bottom: 1.1em;
  }

  #koha_monthly_reports li {
    padding: 1em;
    margin-top: 2em;
    margin-bottom: 2em;
  }

  .koha_reports {
    background-color: #90c2ed;
    color: black;
    padding: 12px 12px 12px 12px;
    border-radius: 16px;
    font-weight: 600;
    font-size: 1.1em;
  }

  .koha_reports:hover {
    background-color: #1f9bde;
    color: black;
    padding: 12px 12px 12px 12px;
    border-radius: 16px;
    font-weight: 600;
    font-size: 1.1em;
  }

  .download_report {
    text-align: left;
    width: 35%;
    background-color: #90c2ed;
    color: black;
    padding: 12px 12px 12px 12px;
    border-radius: 16px;
    font-weight: 600;
    font-size: 1.1em;
    float: left;
  }

  .download_report:hover,
  .download_report:hover a,
  .download_report:focus,
  .download_report:focus a {

    text-align: left;
    width: 35%;
    background-color: #1f9bde;
    color: white;
    text-decoration: none;
    padding: 12px 12px 12px 12px;
    border-radius: 16px;
    font-weight: 600;
    font-size: 1.1em;
  }

  .report_contact {
    text-align: right;
    width: 35%;
    float: right;
    background-color: #e0e0e0;
    color: black;
    padding: 12px 12px 12px 12px;
    border-radius: 16px;
    font-weight: 600;
    font-size: 1.1em;
  }

  .report_contact:hover,
  .report_contact:hover a,
  .report_contact:focus,
  .report_contact:focus a {
    text-align: right;
    width: 35%;
    float: right;
    background-color: #b5b5b5;
    color: black;
    text-decoration: none;
    padding: 12px 12px 12px 12px;
    border-radius: 16px;
    font-size: 1.1em;
    font-weight: 600;
  }

  .report_updated {
    float: right;
    background-color: #9eef8f;
    color: black;
    padding: 12px 12px 12px 12px;
    border-radius: 16px;
    font-weight: 600;
    font-size: 1.1em;
  }

  .statistic_updated {
    background-color: ##9eef8f;
    color: black;
    padding: 12px 12px 12px 12px;
    border-radius: 16px;
    font-weight: 600;
    font-size: 1.1em;
  }

  #main_page_tabs h3 {
    text-align: center;
    margin-left: -.75em;
    margin-right: -.77em;
  }

  #main_page_tabs h2 {
    text-align: center;
    margin-left: -.7em;
    margin-right: -.7em;
  }

  #main_page_tabs h4 {
    background-color: white;
    padding: 6px 6px 6px 6px;
    border-radius: 16px;
  }

  #main_page_tabs h2 {
    text-decoration-line: underline;
    background-color: var(--c_dark);
    color: var(--t_dark);
    padding: 10px;
  }

  #main_page_tabs h3 {
    text-decoration-line: underline;
    background-color: var(--c_medium);
    color: var(--t_medium);
    padding: 10px;
  }

  /* Style tabs */
  .special_tabs>li>a {
    background-color: var(--c_medium);
    color: var(--t_medium);
    border: 2px solid var(--c_medium);
  }

  /* Style on hover */
  .special_tabs>li>a:not(.selected):hover {
    background-color: var(--c_medium_hov);
    color: var(--t_medium_hov);
    border-top: 2px solid var(--c_medium_hov);
    border-right: 2px solid var(--c_medium_hov);
    border-bottom: 0px solid var(--c_medium_hov);
    border-left: 2px solid var(--c_medium_hov);
  }

  /* Style active tab */
  .special_tabs>li>a.selected,
  .special_tabs>li>a.selected:focus {
    background-color: var(--c_light);
    color: var(--t_light);
    padding-top: 1.5em !important;
  }

  /* Style active tab on hover */
  .special_tabs>li>a.selected:hover {
    background-color: var(--c_dark_hov);
    color: var(--t_dark_hov);
  }

  div.mptabContent {
    margin: 1px 0px 0px 0px;
    border: 1px solid #000000;
    padding: 1em;
    background-color: var(--c_light);
  }

  ul.special_tabs {
    list-style-type: none;
    margin: 30px 0px 0px 0px;
    padding: 0em 0em 0em 0em;
  }

  .special_tabs li {
    display: inline;
  }

  ul.special_tabs li a {
    margin: 0px 0px 10px 0px;
    padding: 10px 10px 1px 10px;
    text-decoration: none;
    border-radius: 5px 5px 0px 0px;
    border-top: 1px solid black;
    border-right: 1px solid black;
    border-bottom: 0px solid black;
    border-left: 1px solid black;
  }

  div.mptabContent.hidden {
    display: none;
  }

  .futrow {
    display: none;
  }

  .currow td {
    background-color: var(--c_dark) !important;
    color: var(--t_dark) !important;
  }
  
  .special-notes {
    background-color: #ef8f9e;
    color: black;
    padding: 4px 16px 4px 16px;
    border-radius: 12px;
    font-weight: 600;
  }

  .final-notes {
    background-color: #9eef8f;
    color: black;
    padding: 4px 16px 4px 16px;
    border-radius: 16px;
    font-weight: 600;
  }
  
</style>
<script type="text/javascript">
  //<![CDATA[
  var mptabLinks = new Array();
  var contentDivs = new Array();
  function init() {
    // Grab the mptab links and content divs from the page
    var mptabListItems = document.getElementById('mptabs').childNodes;
    for (var i = 0; i < mptabListItems.length; i++) {
      if (mptabListItems[i].nodeName == "LI") {
        var mptabLink = getFirstChildWithTagName(mptabListItems[i], 'A');
        var id = getHash(mptabLink.getAttribute('href'));
        mptabLinks[id] = mptabLink;
        contentDivs[id] = document.getElementById(id);
      }
    }
    // Assign onclick events to the mptab links, and
    // highlight the first mptab
    var i = 0;
    for (var id in mptabLinks) {
      mptabLinks[id].onclick = showmptab;
      mptabLinks[id].onfocus = function () {
        this.blur()
      };
      if (i == 0) mptabLinks[id].className = 'selected';
      i++;
    }
    // Hide all content divs except the first
    var i = 0;
    for (var id in contentDivs) {
      if (i != 0) contentDivs[id].className = 'mptabContent hide';
      i++;
    }
  }
  function showmptab() {
    var selectedId = getHash(this.getAttribute('href'));
    // Highlight the selected mptab, and dim all others.
    // Also show the selected content div, and hide all others.
    for (var id in contentDivs) {
      if (id == selectedId) {
        mptabLinks[id].className = 'selected';
        contentDivs[id].className = 'mptabContent';
      } else {
        mptabLinks[id].className = '';
        contentDivs[id].className = 'mptabContent hide';
      }
    }
    // Stop the browser following the link
    return false;
  }
  function getFirstChildWithTagName(element, tagName) {
    for (var i = 0; i < element.childNodes.length; i++) {
      if (element.childNodes[i].nodeName == tagName) return element.childNodes[i];
    }
  }
  function getHash(url) {
    var hashPos = url.lastIndexOf('#');
    return url.substring(hashPos + 1);
  }
//]]>
</script>

<body onload="init()">
  <div id="main_page_tabs">
    <h1>Next: staff interface</h1>
    <br />
    <ul id="mptabs" class="special_tabs">
      <li><a href="#tab01" >Upcoming closures at your library</a></li>
      <li><a href="#tab02">Statistics - 2023</a></li>
      <li><a href="#tab03">Unlock a locked account</a></li>
      <li><a href="#tab04" style="display: none;">Tab 4</a></li>
      <li><a href="#tab05">High demand requests</a></li>
      <li><a href="#tab06" style="display: none;">Tab 6</a></li>
    </ul>
    <!--  TAB01 -->

    <div class="mptabContent" id="tab05">

      <h2>High demand requests at your library</h2>

      <div>
        <h3>Request information for your library</h3>
        <p>This table indicates titles that have multiple requests for pickup at your library where one of the following situations is also true:</p>
        <ul>
          <li>Your library owns 0 copies of the title</li>
          <li>There are more than 3 requests per copy system-wide for pickup at your library</li>
        </ul>
        <p>These titles appear to have a high demand and you may want to consider purchasing additional copies.</p>
        <p>This is a cached report. It updates a maximum of one time per hour.</p>
        <p>If there are no items that meet the listed criteria for this report at your library, the report will not show any results.</p>
        <p>&nbsp;</p>
        <p><a href="https://youtu.be/n6__np16LnE" target="_blank">Click here to see a video on this new feature.</a></p>
        <p>&nbsp;</p>
        <p><a href="/cgi-bin/koha/reports/guided_reports.pl?phase=Run+this+report&reports=3263&limit=500" target="_blank">Click here to see all titles with a greater than 3:1 requests to items ratio system-wide.</a>
        </p>
        <p>&nbsp;</p>

        <div id="requesttable">
          <table id="localrequests_table" class="table table-hover table-bordered table-responsive">
            <thead>
              <tr>
                <th>GO_TO_THE<br />BIBLIOGRPHIC<br />RECORD</th>
                <th>Title</th>
                <th>REQUESTS_AT<br />YOUR_LIBRARY</th>
                <th>COPIES_OWNED<br />BY_YOUR_LIBRARY</th>
                <th>SYSTEM_WIDE<br />ITEM_COUNT</th>
                <th>SYSTEM_WIDE<br />REQUEST_COUNT</th>
              </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
        </div>

      </div>

    </div>

    <!--  TABR02 -->

    <div class="mptabContent" id="tab02">
      <h2>Statistics - 2023</h2>
      <p>All 2022 data has been moved to the "Statistics - Prior years" tab on the Reports page.</p>
      <p>The Next Search Catalog coordinator endeavors to update the statistic files by the 5th workday of each month.</p>
      <p><a href="/cgi-bin/koha/reports/reports-home.pl">Reports home page</a></p>

      <div id="montly_overview" class="tab_section">

        <h3>Monthly overview</h3>

        <div id="calendar_year" class="tab_sub_section">
          <h4>Calendar year</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.a.monthly_overview.xlsx">
                2023 monthly overview <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Monthly%20overview%20statistics%20(calendar%20year)%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>
              Includes general monthly statistics for the 2022 calendar year. Includes circulation and renewals, collection size, number of borrowers, number of intra-consortial loans, etc.
            </p>
            <p>
              This spreadsheet is based on reports 3418, 3419, 3420, 3421, and 3422 which are run on the first of each month between 12:05 a.m. and 2:00 a.m.
            </p>
          </section>

        </div>


        <div id="fiscal_year" class="sub_section">
          <h4>Fiscal year (2022/2023)</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.afy.monthly_overview.xlsx">
                Fiscal year monthly overview <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Monthly%20overview%20statistics%20(fiscal%20year)%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.07.03
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>
              Includes general monthly statistics for the 2023 fiscal year (July 1, 2022-June 30, 2023). Includes circulation and renewals, collection size, number of borrowers, number of intra-consortial loans, etc.
            </p>
            <p>
              This spreadsheet is based on reports 3418, 3419, 3420, 3421, and 3422 which are run on the first of each month between 12:05 a.m. and 2:00 a.m.
            </p>
            <p>
              <span class="final-notes">
                Complete for the 2023 (July 1, 2022-June 30, 2023) Fiscal Year
              </span>
            </p>
          </section>

        </div>

      </div>


      <div id="circ_by_library_details" class="tab_section">
        <h3>Circulation by library details</h3>

        <div id="hourly_statistics" class="sub_section">
          <h4>Checkouts / renewals / returns / borrowers / per hour</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.b.circ_by_library.hourly.xlsx">
                Hourly statistics <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Circulation%20by%20library%20(hourly)%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>Cicrulation, return, and borrower count for each hour of the month.</p>
            <p>This spreadsheet is based on report 3499 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

      </div>


      <div id="circ_by_item_details" class="tab_section">
        <h3>Circulation by item details</h3>

        <div id="id" class="sub_section">
          <h4>Circulation count by collection code</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.c.monthly_circ_by_item.ccode.xlsx">
                Circulationby collection code <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Circulation%20by%20collection%20code%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>
          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>The collection code "Music CD" was renamed "Music : compact disc" on June 2.</p>
            <p>A new collection code "Music : record" was added on June 2.</p>
            <p>
              <span class="special-notes">The following new collection codes were added in October:</span>
              <ul>
                <li>Audio-visual equipment</li>
                <li>Blu-ray player</li>
                <li>Record player</li>
                <li>Musical instrument : brass instruments</li>
                <li>Musical instrument : drums and percussion</li>
                <li>Musical instrument : misceleaneous</li>
                <li>Musical instrument : stringed instruments</li>
                <li>Musical instrument : woodwind instruments</li>
              </ul>
            </p>
            <p>This spreadsheet is based on report 3494 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

        <div id="circ_count_by_item_type" class="sub_section">
          <h4>Circulation count by item type</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.c.monthly_circ_by_item.itype.xlsx">
                Circulation by item type <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Circulation%20by%20item%20type%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <div class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </div>

          <div class="clearfix"></div>

          <div>
            <p>
              <span class="special-notes">The following new item types were added in October:</span>
              <ul>
                <li>Things : Audio-visual equipment</li>
                <li>Things : Musical insturments and accessories</li>
              </ul>
            </p>
            <p>This spreadsheet is based on report 3493 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </div>

        </div>

      </div>


      <div id="circ_by_borrower_details" class="tab_section">
        <h3>Circulation by borrower details</h3>

        <div id="circ_by_borrower_category" class="sub_section">
          <h4>Circulation by borrower category</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.d.monthly_circ_by_borrower.category.xlsx">
                Circulation by borrower category <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Circulation%20by%20borrower%20category%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>This spreadsheet is based on report 3701 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

        <div id="unique_borrowers" class="sub_section">
          <h4>Unique borrowers at a library</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.d.monthly_circ_by_borrower.unique_borrowers.xlsx">
                Unique borrowers at your library <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Unique%20borrowers%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>This spreadsheet is based on report 3355 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

        <div id="circ_by_borrower_zipcode" class="sub_section">
          <h4>Circulation by borrower's zipcode</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.d.monthly_circ_by_borrower.zipcode.xlsx">
                Circulation by borrower zip code <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Circulation%20by%20borrower%20zip%20code%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>This spreadsheet is based on report 3505 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

      </div>


      <div id="borrower_statistics" class="tab_section">
        <h3>Borrower statistics</h3>

        <div id="borrower_count" class="sub_section">
          <h4>Borrower count by borrower category</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.e.borrower_count.category.xlsx">
                Borrower count by category <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Borrower%20count%20by%20category%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>This spreadsheet is based on report 3539 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

        <div id="borrower_count_by_zipcode" class="sub_section">
          <h4>Borrower count by zip code</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.e.borrower_count.zipcode.xlsx">
                Borrower count by zip code <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto link">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>This spreadsheet is based on report 3548 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

      </div>

      <div id="items_and_holdings_statistics" class="tab_section">
        <h3>Items and holdings statistics</h3>

        <div id="item_count_by_collection_code" class="sub_section">
          <h4>Item count by collection code</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.f.item_count.ccode.xlsx">
                Item count by collection code <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto link">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>The collection code "Music CD" was renamed "Music : compact disc" on June 2.</p>
            <p>A new collection code "Music : record" was added on June 2.</p>
            <p>
              <span class="special-notes">The following new collection codes were added in October:</span>
              <ul>
                <li>Audio-visual equipment</li>
                <li>Blu-ray player</li>
                <li>Record player</li>
                <li>Musical instrument : brass instruments</li>
                <li>Musical instrument : drums and percussion</li>
                <li>Musical instrument : misceleaneous</li>
                <li>Musical instrument : stringed instruments</li>
                <li>Musical instrument : woodwind instruments</li>
              </ul>
            </p>
            <p>This spreadsheet is based on report 3537 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

        <div id="item_count_by_item_type" class="sub_section">
          <h4>Item count by item type</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.f.item_count.itype.xlsx">
                Item count by item type <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto link">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>
              <span class="special-notes">The following new item types were added in October:</span>
              <ul>
                <li>Things : Audio-visual equipment</li>
                <li>Things : Musical insturments and accessories</li>
              </ul>
            </p>
            <p>This spreadsheet is based on report 3530 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

      </div>

      <div id="requests_and_sharing_statistics" class="tab_section">
        <h3>Request and sharing statistics</h3>

        <div id="net_borrower_lender" class="sub_section">
          <h4>Net borrower / net lender report</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.g.net_borrower_lender.xlsx">
                Net borrower/net lender <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Net%20lender%20statistics%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>This spreadsheet is based on report 3184 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

        <div id="request_statistics" class="sub_section">
          <h4>Request statistics</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.g.requests.statistics.xlsx">
                Request statistics <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Request%20statistics%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>This spreadsheet is based on report 2975 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
          </section>

        </div>

        <div id="sharing_statistics" class="sub_section">
          <h4>Sharing statistics</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2023/2023.g.sharing.statistics.xlsx">
                Sharing statistics <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Sharing%20statistics%20question%20(Excel%20file)">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.12.01
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>This spreadsheet is based on report 3200 which is run on the first of each month between 12:05 a.m. and 2:00 a.m.</p>
            <p><span class="special-notes">New for 2023</span></p>
          </section>

        </div>

      </div>

      <div id="electronic_materials_statistics" class="tab_section">
        <h3>Electronic materials statistics</h3>

        <div id="electronic_circ" class="sub_section">
          <h4>System-wide electronic resources</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="View on Google sheets" href="https://docs.google.com/spreadsheets/d/1GRGdNp7w_xtyMzxGaDHq_LP0vnmmyhHDflMht3L7Xh4/edit?usp=sharing">
                2023 E-resources statistics <i class="fa fa-google" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20Robin%20-%20Electronic%20materials%20statistics%20question%20(Google%20spreadsheet)">
                Maintained by Robin Hastings <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated 2023.09.04
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>Statistics are for system-wide useage. Because of limitations of these platforms, it is not possible to know usage on a library-by-library basis.</p>
          </section>

        </div>

      </div>

      <div id="2023_state_survey" class="tab_section">

        <h3>2023 state statistical survey</h3>
        <p>Published each year in early January</p>

        <div id="state_statistics_2023" class="sub_section" style="display: none;">
          <h4>2023 data</h4>
          <section class="report_links">
            <p>
              <a class="download_report" title="Download Excel file" href="link">
                2023 State statistical survey data related to Next Search Catalog <i class="fa fa-download" aria-hidden="true"></i>
              </a>
            </p>
            <p>
              <a class="report_contact" title="Send e-mail" href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%202023%20year%20end%20statistics%20question">
                Maintained by George Williams <i class="fa fa-envelope" aria-hidden="true"></i>
              </a>
            </p>
          </section>

          <div class="clearfix"></div>

          <section class="report_updated">
            <time>
              Updated DATE
            </time>
          </section>

          <div class="clearfix"></div>

          <section class="report_metadata">
            <p>Report metadata</p>
          </section>

        </div>

        <div>
          <h4>Go to the reports home page and click on the "Statistics - Prior years" tab for 2017-2022 survey data.</h4>
          <p><a href="/cgi-bin/koha/reports/reports-home.pl">Reports home page</a></p>
        </div>

      </div>

      <div id="koha_monthly_reports" class="tab_section">
        <h3>Next search catalog monthly reports for libraries</h3>

        <div id="koha_general_reports" class="sub_section">
          <h4>General monthly reports</h4>
          <section class="report_links">

            <p>All reports show data for the previous calendar month.<br />Click on the link to run the report for your library.</p>

            <ul>

              <li>
                <a class="koha_reports" title="Run this report" href="/cgi-bin/koha/reports/guided_reports.pl?reports=3702&phase=Run%20this%20report" target="_blank">
                  Checkout and renewal count by permanent shelving location and collection code
                  <i class="fa fa-table" aria-hidden="true"></i>
                </a>
              </li>
              <li>
                <a class="koha_reports" title="Run this report" href="/cgi-bin/koha/reports/guided_reports.pl?reports=3703&phase=Run%20this%20report" target="_blank">
                  Checkout and renewal count by permanent shelving location and item type
                  <i class="fa fa-table" aria-hidden="true"></i>
                </a>
              </li>
              <li>
                <a class="koha_reports" title="Run this report" href="/cgi-bin/koha/reports/guided_reports.pl?reports=3704&phase=Run%20this%20report" target="_blank">
                  Borrower counts by category: total borrowers plus borrower added, renewed, and deleted
                  <i class="fa fa-table" aria-hidden="true"></i>
                </a>
              </li>
              <li>
                <a class="koha_reports" title="Run this report" href="/cgi-bin/koha/reports/guided_reports.pl?reports=3705&phase=Run%20this%20report" target="_blank">
                  Materials added count by permanent shelving location and collection code
                  <i class="fa fa-table" aria-hidden="true"></i>
                </a>
              </li>
              <li>
                <a class="koha_reports" title="Run this report" href="/cgi-bin/koha/reports/guided_reports.pl?reports=3706&phase=Run%20this%20report" target="_blank">
                  Materials added count by permanent shelving location and item type
                  <i class="fa fa-table" aria-hidden="true"></i>
                </a>
              </li>

            </ul>

          </section>

        </div>

        <div id="koha_detailed_reports" class="sub_section">
          <h4>Detailed monthly reports</h4>
          <section class="report_links">

            <p>All reports show data for the previous calendar month.<br />Click on the link to run the report for your library.</p>

            <ul>

              <li>
                <a class="koha_reports" title="Run this report" href="/cgi-bin/koha/reports/guided_reports.pl?reports=3160&phase=Run%20this%20report" target="_blank">
                  Materials added in the previous calendar month
                  <i class="fa fa-table" aria-hidden="true"></i>
                </a>
              </li>
                <p>
                  <span class="special-notes">
                    "Materials added in the previous calendar month" was updated on 2023.07.21 to fix a home library/holding library problem
                  </span>
                </p>
              <li>
                <a class="koha_reports" title="Run this report" href="/cgi-bin/koha/reports/guided_reports.pl?reports=3161&phase=Run%20this%20report" target="_blank">
                  Borrower added in the previous calendar month (review for errors/typos/etc.)
                  <i class="fa fa-table" aria-hidden="true"></i>
                </a>
              </li>

            </ul>

          </section>

        </div>


      </div>


      <div id="stats_table" class="tab_section">

        <h3>Next Search Catalog 2023 overall statistics</h3>

        <table>
          <tr>
            <th>2023</th>
            <th id="eomitotalhd">Total items</th>
            <th id="eombtotalhd">Total titles</th>
            <th id="eomptotalhd">Total patrons</th>
            <th id="eomctotalhd">Total Circulation<br />this month</th>
            <th id="eoyctotalhd">Total Circ for 2023 through<br />the end of this month</th>
          </tr>
          <tr class="futrow">
            <td>December</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr class="currow">
            <td>November</td>
            <td>1003617</td>
            <td>406657</td>
            <td>116045</td>
            <td>84962</td>
            <td>1032513</td>
          </tr>
          <tr>
            <td>October</td>
            <td>1003348</td>
            <td>406004</td>
            <td>115554</td>
            <td>89776</td>
            <td>947551</td>
          </tr>
          <tr>
            <td>September</td>
            <td>1001685</td>
            <td>405147</td>
            <td>115450</td>
            <td>89740</td>
            <td>857775</td>
          </tr>
          <tr>
            <td>August</td>
            <td>1001346</td>
            <td>404999</td>
            <td>114617</td>
            <td>98924</td>
            <td>768035</td>
          </tr>
          <tr>
            <td>July</td>
            <td>1006627</td>
            <td>406149</td>
            <td>113232</td>
            <td>101818</td>
            <td>669111</td>
          </tr>
          <tr>
            <td>June</td>
            <td>1015332</td>
            <td>408685</td>
            <td>111832</td>
            <td>114493</td>
            <td>567293</td>
          </tr>
          <tr>
            <td>May</td>
            <td>1009397</td>
            <td>406671</td>
            <td>110538</td>
            <td>95894</td>
            <td>452800</td>
          </tr>
          <tr>
            <td>April</td>
            <td>1003417</td>
            <td>404616</td>
            <td>109670</td>
            <td>84778</td>
            <td>356906</td>
          </tr>
          <tr>
            <td>March</td>
            <td>998912</td>
            <td>402951</td>
            <td>109163</td>
            <td>98440</td>
            <td>272128</td>
          </tr>
          <tr>
            <td>February</td>
            <td>999869</td>
            <td>402840</td>
            <td>109441</td>
            <td>84022</td>
            <td>173688</td>
          </tr>
          <tr>
            <td>January</td>
            <td>1003052</td>
            <td>402995</td>
            <td>108792</td>
            <td>89666</td>
            <td>89666</td>
          </tr>
        </table>

        <div class="report_metadata">
          <p>
            <span class="statistic_updated">
              Updated 2023.12.01
            </span>
          </p>
        </div>

      </div>


      <div id="monthly_graph" class="tab_section">

        <h3>Graph of circulation by month over time</h3>
        <img src="https://raw.githubusercontent.com/northeast-kansas-library-system/next_statistics/main/images/2023/2023.00.svg" alt="2019-2023 Statistics Graph" width="90%" style="border: 8px solid #000000;">

        <div class="report_metadata">
          <p>
            <span class="statistic_updated">
              Updated 2023.12.01
            </span>
          </p>
        </div>

      </div>

    </div>

    <!--  TABR03 -->

    <div class="mptabContent" id="tab03">
      <h2>Locked accounts</h2>

      <div>
        <p style="display: none;">For the full instruction sheet, <a href="https://will1410.github.io/next.training/staffmodules/circulation/circulationproblems.html#patron-account-locked-due-to-too-many-login-attempts" target="_blank">click here</a></p>
        <h3>Locked account report:</h3>
        <p>Run report 3019 to see all patrons who have been locked out of their accounts. (<a href="/cgi-bin/koha/reports/guided_reports.pl?reports=3019&phase=Run%20this%20report" target="_blank">Click here to run report 3019 in a new window</a>)</p>
        <ul>
          <li>If you wish to see all patrons who have been locked out, choose a library from the drop-down menu and leave the asterisk in the card number field.</li>
          <li>If you wish to check a specific patron, leave the drop-down set to "All libraries" and enter the patron's barcode number in the card number field.</li>
        </ul>
        <p>If a patron does not appear on the list, their account has not been locked out.</p>
        <h3>Re-setting an account</h3>
        <p>To unlock an account from the staff client:</p>
        <ol>
          <li>Navigate to the patron's account</li>
          <li>Click on the "Change password" button</li>
          <li>Enter the new password in the password fields</li>
        </ol>
        <p>Please note that "SYSTEM login only" accounts, "Library Associate" accounts, and "NEKLS Test Account" accounts cannot be reset by other staff members (only system administrators can edit passwords for these types of accounts).</p>
      </div>

    </div>

    <!--  TABR04 -->

    <div class="mptabContent" id="tab04">

      <h2>Tab 04</h2>

    </div>

    <!--  TABR05 -->

    <div class="mptabContent" id="tab01">
      <h2>Upcoming closures at your library</h2>
  
      <div id="closures">
        <p><br />This is a list of the upcoming closures at your library in the next 12 months.</p>
        <table id="closures_table" class="table table-hover table-bordered">
          <thead>
            <tr>
              <th>Branch Code</th>
              <th>Closed date</th>
              <th>Title</th>
              <th>Frequency</th>
            </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
        <p>When a date is marked as "Closed" on your library's calendar in Koha, no items will be due on that date. Any items you check out that would normally be due on a closed date are automatically pushed to the next open date on your library's calendar. Setting closure dates is not necessary, but failing to set closure dates can be confusing for borrowers.</p>
        <p>Library directors can set the closure dates for their libraries. <a href="https://northeast-kansas-library-system.github.io/nextsteps/pages/tools/calendar/index.html" target="_blank">Please click here for the training materials on updating your calendar.</a></p>
        <p>NEKLS staff can also set closure dates for your library if you desire. If you would like NEKLS staff to add closed dates to your calendar, please send any dates for the next 12 months in the format MM/DD/YYYY to <a href="mailto:nexthelp@nekls.org?subject=attn%3A%20George%20-%20Update%20library%20calendar%20in%20Koha&body=Closure dates%20must%20be%20in%20the%20mm%2Fdd%2Fyyyy%20format">nexthelp@nekls.org by clicking on this link</a></p>
      </div>
  
    </div>

    <!--  TABR06 -->

    <div class="mptabContent" id="tab06">

      <h2>Tab title</h2>

    </div>

  </div>

</body>






















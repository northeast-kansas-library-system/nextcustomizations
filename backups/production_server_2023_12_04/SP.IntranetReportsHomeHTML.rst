SP.IntranetReportsHomeHTML.txt

----------

Preference name: IntranetReportsHomeHTML

Type: Free

Options: 

----------

Preference value: 



<style type="text/css">
  ul#mptabs {
    list-style-type: none;
    margin: 30px 0 0 0;
    padding: 0 0 0.3em 0;
  }

  ul#mptabs li {
    display: inline;
  }

  ul#mptabs li a {
    color: #42454a;
    background-color: #dedbde;
    border: 1px solid #c9c3ba;
    border-bottom: none;
    padding: 0.3em;
    text-decoration: none;
  }

  ul#mptabs li a:hover {
    background-color: #f1f0ee;
  }

  ul#mptabs li a.selected {
    color: #000;
    background-color: #f1f0ee;
    font-weight: bold;
    padding: 0.7em 0.3em 0.38em 0.3em;
  }

  div.mptabContent {
    border: 1px solid #c9c3ba;
    padding: 0.5em;
    background-color: #f1f0ee;
  }

  div.mptabContent {
    padding: 2% 2% 2% 2%;
  }

  div.mptabContent.hide {
    display: none;
  }

  #stat1 {
    background-color: #d8d8d6 !important;
  }

  #stat2 {
    background-color: #c0c0be !important;
  }

  #stat3 {
    background-color: #a8a8a6 !important;
  }

  .futrow {
    display: none;
  }

  .currow td {
    background-color: #ffff80 !important;
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
      mptabLinks[id].onfocus = function() {
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
  <h1>Next Search Catalog</h1>
  <ul id="mptabs">
    <li><a href="#tabR01">Missing in transit</a></li>
    <li><a href="#tabR02">Auto deletion</a></li>
    <li><a href="#tabR03" style="display: none;">Statistics - 2018</a></li>
    <li><a href="#tabR04">Statistics - Prior years</a></li>
    <li><a href="#tabR05">PayPal reports</a></li>
    <li><a href="#tabR06" style="display:none;">Tab 6</a></li>
  </ul>
  <!-- TABR01 MIT -->
  <div class="mptabContent" id="tabR01">
    <h2>Missing in transit</h2>
    <div>
      <h3>Missing in transit</h3>
      <p>Report 3658 generates a list of items that are missing in transit that are either owned by, being shipped to, or being shipped from the library you select.<br /><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=3658&phase=Run%20this%20report" target="_blank">Click here to run report 3658 in a new window</a></p>
      <p>Report 3658 replaces all previous missing in transit reports.</p>
    </div>
  </div>
  <!-- TABR02 auto deletion -->
  <div class="mptabContent" id="tabR02">
    <h2>Automatic deletion of items</h2>
    <div>
      <h3>Items about to be automatically deleted</h3>
      <p>Report 2959 generates a list of items that are about to be deleted.<br /><br />If you run this report and choose your library from the drop-down, you will see a list of all of the items that will be deleted automatically between today and
        the last day of the month, two calendar months from now. If you run this report on March 15, you will see everything that is expected to be deleted between March 15 and May 31. If you run it on November 29, you will see everything that is
        expected to be automatically deleted between November 29 and January 31 of the following year.</p>
      <p><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=2959&phase=Run%20this%20report" target="_blank">Click here to run report 2959 in a new window</a></p>
      <h3>Deleted items list by date range</h3>
      <p>Report 2958 generates a list of items that have already been deleted.<br /><br />This will show you a list of items that have already been deleted during the date range you specify up to the previous 13 months. Since data is only kept in the
        deleteditems table for 13 months, you will not be able to generate list going back further than 13 months ago.</p>
      <p><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=2958&phase=Run%20this%20report" target="_blank">Click here to run report 2958 in a new window</a></p>
      <h3>Deleted item information</h3>
      <p>Report 2883 allows you to lookup information on a single item that has been deleted by entering its barcode number.</p>
      <p><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=2883&phase=Run%20this%20report" target="_blank">Click here to run report 2883 in a new window</a></p>
    </div>
  </div>
  <!-- TABR03 2018 statistics -->
  <div class="mptabContent" id="tabR03" style="display: none;">
    <h2>Statistics - 2019</h2>
    <br />
    <div>
      <div id="stat1">
        <p>Request statistics - Excel spreadsheet.</p>
        <p>Updated 2019.01.01</p>
        <p><span style="color: white; background-color: red;">Special note:</span> After the upgrade in July there were significant errors in the <ins>Request statistics</ins> report that were not identified until November. All reports from November
          4 onwards should reflect accurate data and correct the errors for July, August, and September.</p>
        <p><ins><a href="https://drive.google.com/uc?id=11CjyhXMEa2L4OHEVadXFmJEmzZu-03NR&export=download">2018 request statistics (Excel file - switch tabs at the bottom of the screen to view different months)</a></ins></p>
        <p>-----</p>
        <p><span style="color: black; background-color: yellow;">Annual statistical survey data - Excel spreadsheet.</span></p>
        <p><ins><a href="https://drive.google.com/uc?id=1CqvL_UcB34JcHn0VoDOkVQm-uN0cR2Lc&export=download">2018 state survey data (Excel file - switch tabs at the bottom of the screen to view 2017 data)</a></ins></p>
        <p><span style="color: white; background-color: red;">Special note:</span> The data in columns K and L were inverted in the original version of this file. The file was updated on January 8 to reflect the correct data.</p>
        <p>Updated 2019.01.08</p>
        <p>-----</p>
      </div>
      <div id="stat2">
        <h5>Detailed reports</h5>
        <p>Circulation Reports for Item Type & Ccode Breakdown, New Acquisitions, and Newly Added Patrons in this month.</p>
        <p>Directions to run these: Dropdowns: choose your library; month: choose this month; year: choose this year and click "Run the report."<br />If you want to download, print, and/or resort the report, scroll to the bottom to download the
          report, save to your computer, and open in Excel or another spreadsheet software.</p>
        <ul>
          <li><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=1930&phase=Run%20this%20report" target="_blank">Circulation by Item Type</a></li>
          <li><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=1929&phase=Run%20this%20report" target="_blank">Circulation by Collection Code</a></li>
          <li><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=536&phase=Run%20this%20report" target="_blank">New Acquisitions</a></li>
          <li><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=555&phase=Run%20this%20report" target="_blank">Review newly added patrons</a></li>
        </ul>
        <p>Reports for new patrons and new materials</p>
        <p>To run these reports, click on the link and choose your library. The report will automatically set the date to gather the data for the previous calendar month.</p>
        <ul>
          <li><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=2903&phase=Run%20this%20report" target="_blank">New Patrons by Category</a></li>
          <li><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=2902&phase=Run%20this%20report" target="_blank">New Materials by Item Type & Location</a></li>
          <li><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=2901&phase=Run%20this%20report" target="_blank">New Materials by Collection Code & Location</a></li>
        </ul>
        <p>-----</p>
      </div>
      <div id="stat3">
        <h5>NExpress 2018 overall statistics</h5>
        <table class="tg">
          <tr>
            <th>2018</th>
            <th id="eomitotalhd">Total items</th>
            <th id="eombtotalhd">Total titles</th>
            <th id="eomptotalhd">Total patrons</th>
            <th id="eomctotalhd">Total Circulation<br />this month</th>
            <th id="eoyctotalhd">Total Circ for 2018 through<br />the end of this month</th>
          </tr>
          <tr class="currow">
            <td>December</td>
            <td>1058712</td>
            <td>432234</td>
            <td>118175</td>
            <td>99895</td>
            <td>1529206</td>
          </tr>
          <tr>
            <td>November</td>
            <td>1044007</td>
            <td>405543</td>
            <td>122979</td>
            <td>110036</td>
            <td>1429311</td>
          </tr>
          <tr>
            <td>October</td>
            <td>1045655</td>
            <td>421894</td>
            <td>123233</td>
            <td>127753</td>
            <td>1319275</td>
          </tr>
          <tr>
            <td>September</td>
            <td>1046428</td>
            <td>420330</td>
            <td>122581</td>
            <td>116766</td>
            <td>1191522</td>
          </tr>
          <tr>
            <td>August</td>
            <td>1046816</td>
            <td>419147</td>
            <td>133697</td>
            <td>137007</td>
            <td>1074756</td>
          </tr>
          <tr>
            <td>July</td>
            <td>1042834</td>
            <td>409275</td>
            <td>133529</td>
            <td>152516</td>
            <td>937749</td>
          </tr>
          <tr>
            <td>June</td>
            <td>1043053</td>
            <td>411942</td>
            <td>132519</td>
            <td>161867</td>
            <td>785233</td>
          </tr>
          <tr>
            <td>May</td>
            <td>1045605</td>
            <td>413840</td>
            <td>131574</td>
            <td>130623</td>
            <td>623366</td>
          </tr>
          <tr>
            <td>April</td>
            <td>1041794</td>
            <td>411325</td>
            <td>130687</td>
            <td>120444</td>
            <td>492743</td>
          </tr>
          <tr>
            <td>March</td>
            <td>1038195</td>
            <td>410354</td>
            <td>130269</td>
            <td>130786</td>
            <td>372299</td>
          </tr>
          <tr>
            <td>February</td>
            <td>1038217</td>
            <td>409477</td>
            <td>129761</td>
            <td>115343</td>
            <td>241513</td>
          </tr>
          <tr>
            <td>January</td>
            <td>1044433</td>
            <td>410068</td>
            <td>129209</td>
            <td>126170</td>
            <td>126170</td>
          </tr>
        </table>
        <p><span>Updated 2019.01.01</p>
        <p>-----</p>
      </div>
    </div>
  </div>
  <!-- TABR04 NEW TAB Prior year statistics -->
  <div class="mptabContent" id="tabR04">
    <h2>Statistics - Prior years</h2>
    <br />
    <div>
      <div id="stat1">

        <div id="overview">
          <h4>Monthly overview</h4>
          <div>
            <p>Calendar year</p>
            <br />
            <p><ins><a href="https://github.com/northeast-kansas-library-system/next_statistics/blob/main/statistics_files/2022/2022.a.monthly_overview.xlsx?raw=download">2022 monthly overview</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=14MOrtv7HVX0tfHpKhCPHIEESjsFMZzts&export=download">2021 monthly overview</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1FPFNhtnI6TOPAaSs-mta15ekjKVkFPVN&export=download">2020 monthly overview</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1G1jigRDGgwHW5K5qn01JiUPk2IRx9WLt&export=download">2019 monthly overview</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=10OQb9V8xdlXLqxJ85VdcnJZxxFfIQyiT&export=download">2018 monthly overview</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=19ytkOha3HR8hEncIjwkrh-f0af5N72MA&export=download">2017 monthly overview</a></ins></p>
            <br />
            <p>We began keeping this data in this format in 2017</p>
            <p>-----</p>
          </div>
          <div style="display: none;">
            <p>Fiscal year</p>
            <p></p>
            <p>-----</p>
          </div>
        </div>

        <div id="circulation_by_library_details">
          <h4>Circulation statistics by library details</h4>
          <div>
            <p>Checkouts / renewals / returns / borrowers / per hour<br /></p>
            <br />
            <p><ins><a href="https://github.com/northeast-kansas-library-system/next_statistics/blob/main/statistics_files/2022/2022.b.circ_by_library.hourly.xlsx?raw=true">2022 hourly statistics</a></ins></p>
            <br />
            <p>We began keeping this data in this format in 2022</p>
            <p>-----</p>
          </div>
        </div>

        <div id="circulation_by_item_details">
          <h4>Circulation statistics by item details</h4>
          <div>
            <p>Circulation statistics by collection code</p>
            <br />
            <p><ins><a href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2022/2022.c.monthly_circ_by_item.ccode.xlsx">2022 monthly circulation by collection code</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=15CU4wsuzgq5YWLT4imeBFdNEzXKpb6hx&export=download">2021 monthly circulation by collection code</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1--h2iH48ReKEukimfljORMQM3XU_BAPn&export=download">2020 monthly circulation by collection code</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1D7fJ065FEUro-nJIAtjtS_uOXVD4k8Zm&export=download">2019 monthly circulation by collection code</a></ins></p>
            <br />
            <p><br />We began keeping this data in this format in 2019</p>
            <p>-----</p>
          </div>
          <div>
            <p>Circulation statistics by item type</p>
            <br />
            <p><ins><a href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2022/2022.c.monthly_circ_by_item.itype.xlsx">2022 monthly circulation by item type</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=15AXs0cIpM87y_PjAxt1oetM-r2bUSvmi&export=download">2021 monthly circulation by item type</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1-0NdJavLnQmwTD02EMenH4fnGM2f6vS1&export=download">2020 monthly circulation by item type</a></ins></p>
            <br />
            <p>We began keeping this data in this format in 2020</p>
            <p>-----</p>
          </div>        
        </div>
        
        <div>
          <h4>Circulation statistics by borrower details</h4>
          <div>
            <p>Unique borrower count</p>
            <br />
            <p><ins><a href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2022/2022.d.monthly_circ_by_borrower.unique_borrowers.xlsx">2022 unique borrower count</a></ins></p>
            <br />
            <p>We began keeping this data in this format in 2022</p>
            <p>-----</p>
          </div>
          <div>
            <p>Circulation statistics by zip code</p>
            <br />
            <p><ins><a href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2022/2022.d.monthly_circ_by_borrower.zipcode.xlsx">2022 monthly circulation by zip code</a></ins></p>
            <br />
            <p>If a zip code has fewer than 10 registered borrowers, that zip code will be recorded as "-" in order to protect the privacy of those individuals.</p>          
            <p>We began keeping this data in this format in 2022</p>
            <p>-----</p>
          </div>
        </div>

        <div id="borrower_statistics">
          <h4>Borrower statistics</h4>
          <div>
            <p>Borrower count by borrower category</p>
            <br />
            <p><ins><a href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2022/2022.e.borrower_count.category.xlsx">2022 borrowers by category</a></ins></p>
            <br />
            <p>We began keeping this data in this format in 2022</p>
            <p>-----</p>
          </div>
          <p>Borrower count by zip code</p>
          <br />
          <div>
            <p><ins><a href="https://github.com/northeast-kansas-library-system/next_statistics/raw/main/statistics_files/2022/2022.e.borrower_count.zipcode.xlsx">2022 borrowers by zip code</a></ins></p>
            <br />
            <p>If a zip code has fewer than 10 registered borrowers, that zip code will be recorded as "-" in order to protect the privacy of those individuals.</p>
            <p>We began keeping this data in this format in 2022</p>
            <p>-----</p>
          </div>
        </div>

        <div id="request_and_sharing_statistics">
          <h4>Request and resource sharing statistics</h4>
          <div>
            <p><ins><a href="https://github.com/northeast-kansas-library-system/next_statistics/blob/main/statistics_files/2022/2022.g.requests.itype.xlsx?raw=true">2022 request statistics</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=14yFCA4Hq4_59T1OMQbTEhCv9GjeV-4QS&export=download">2021 request statistics</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1FQysrULpkGeIx1kGtDiaqNERN66BnL2W&export=download">2020 request statistics</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1CwpgGiOTVrghLAK27ox1PGBeha2I_2xr&export=download">2019 request statistics</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=11CjyhXMEa2L4OHEVadXFmJEmzZu-03NR&export=download">2018 request statistics</a></ins></p>
            <br />
            <p>We began keeping this data in this format in 2018</p>
            <p>-----</p>
          </div>
        </div>

        <div id="electronic_materials_statistics">
          <h4></h4>
          <div>
            <p>Electronic resources statistics</p>
            <br />
            <p><ins><a href="https://docs.google.com/spreadsheets/d/1b2RUvUvtim6Y9m1jtgjJN4q3XJ9y4Mk760iac_2BylY/edit?usp=sharing">2022 e-resources statistics</a></ins></p>
            <p><ins><a href="https://docs.google.com/spreadsheets/d/1B-c4jWhSgIzItt6B35OznegQDQguDLyKEbWPwle8tMw/edit?usp=sharing">2021 e-resources statistics</a></ins></p>
            <br />
            <p>-----</p>
          </div>
        </div>

        <div id="state_survey_statistics">
          <h4>State survey statistics from Next Search Catalog</h4>
          <br />
          <div>
            <p><ins><a href="https://github.com/northeast-kansas-library-system/next_statistics/blob/main/statistics_files/2022/99.year.end/2022.state.survey.xlsx?raw=true">2022 Annual statistical survey data - Excel spreadsheet.</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1Oms_BMK6VmoqAJwEYm9KThoo5J0wRXyO&export=download">2021 Annual statistical survey data - Excel spreadsheet.</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=14JLkcNBCgDFQXhqw1onEdWTA5xeLEUte&export=download">2020 Annual statistical survey data - Excel spreadsheet.</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1FdBmQ1KoZvV5vIxh89843s45hepnHbQI&export=download">2019 Annual statistical survey data - Excel spreadsheet.</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1CqvL_UcB34JcHn0VoDOkVQm-uN0cR2Lc&export=download">2018 Annual statistical survey data - Excel spreadsheet.</a></ins></p>
            <p><ins><a href="https://drive.google.com/uc?id=1RR5b0DznKS8ItILZKIbMsuX5ZvEMCY63&export=download">2017 Annual statistical survey data - Excel spreadsheet.</a></ins></p>
            <br />
            <p>Older data is available from the State Library of Kansas (see the link below)</p>
            <p>-----</p>
          </div>
        </div>

      <div id="stat2">
        <h5>Kansas Public Library Services Annual Surveys</h5>
        <p>The State Library of Kansas has a page that can take you to reports submitted in the past from libraries across the state. Some data can be found as far back as 1910.</p>
        <p><ins><a href="https://kslib.info/1131/Statistical-Data-Reports" target="_blank">Click here to go to the State Library's public library data archive.</a></ins></p>
        <p>-----</p>
      </div>
      <div id="stat3">
        <h5>Next annual statistics summary</h5>
        <table class="tg">
          <tr>
            <th>End of year</th>
            <th>Total items</th>
            <th>Total titles</th>
            <th>Total patrons</th>
            <th>Total Circulation</th>
          </tr>
          <tr>
            <td>2022</td>
            <td>1005962</td>
            <td>403279</td>
            <td>108652</td>
            <td>1073284</td>
          </tr>
          <tr>
            <td>2021</td>
            <td>1011992</td>
            <td>402030</td>
            <td>115455</td>
            <td>990017</td>
          </tr>
          <tr>
            <td>2020</td>
            <td>1025310</td>
            <td>405078</td>
            <td>123251</td>
            <td>802267</td>
          </tr>
          <tr>
            <td>2019</td>
            <td>1030825</td>
            <td>407228</td>
            <td>119204</td>
            <td>1458904</td>
          </tr>
          <tr>
            <td>2018</td>
            <td>1058712</td>
            <td>432234</td>
            <td>118175</td>
            <td>1529206</td>
          </tr>
          <tr>
            <td>2017</td>
            <td>1045809</td>
            <td>410110</td>
            <td>128560</td>
            <td>1629601</td>
          </tr>
          <tr>
            <td>2016</td>
            <td>1041850</td>
            <td>394901</td>
            <td>118751</td>
            <td>1696577</td>
          </tr>
          <tr>
            <td>2015</td>
            <td></td>
            <td></td>
            <td></td>
            <td>1754867</td>
          </tr>
          <tr>
            <td>2014</td>
            <td></td>
            <td></td>
            <td>121229</td>
            <td>1762669</td>
          </tr>
          <tr>
            <td>2013</td>
            <td>967155</td>
            <td></td>
            <td>121897</td>
            <td>1812078</td>
          </tr>
          <tr>
            <td>2012</td>
            <td>923435</td>
            <td></td>
            <td>110059</td>
            <td>1763730</td>
          </tr>
          <tr>
            <td>2011</td>
            <td>904401</td> <!-- Z:\Services\Next\NExpress old\Statistical Reports\2011 Stats\2011 Year End\2011 collection size.xls -->
            <td></td>
            <td>118421</td> <!-- Z:\Services\Next\NExpress old\Statistical Reports\2011 Stats\2011 Year End\Copy of NExpress Patron Counts 021012.xls -->
            <td>1530357</td> 
          </tr>
        </table>
        <p>Notes: No data is readily available prior to January 2011. Available data from 2011-2015 is incomplete.</p>
        <p>-----</p>
      </div>
    </div>
  </div>
  <!-- TABR05 NEW TAB -->
  <div class="mptabContent" id="tabR05">
    <h2>PayPal information</h2>
    <div>
      <h5>Paypal</h5>
      <p>Patrons can make payments on their account through the OPAC using PayPal. PayPal charges at transaction fee of $.30 plus 2.9% on every transaction.</p>
      <p>The net proceeds of money collected via PayPal is distributed to the library where the money is due on a quarterly basis. Money collected in January, February, and March will be distributed in April; money collected in April, May, and June
        will be distributed in July; money collected in July, August, and September will be distributed in October; money collected in October, November, and December will be distributed in January of the following year.</p>
      <p>------</p>
      <h5>Paypal reports</h5>
      <p>The first report below shows PayPal income for the previous calendar month.</p>
      <p>The second report shows PayPal income for the previous calendar month. This report cannot look for PayPal payments that occurred prior to July 2018.</p>
      <p id="rquickopen"><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=3022&phase=Run%20this%20report" target="_blank">PayPal payments for the previous calendar month</a></p>
      <p id="rquickopen"><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=3162&phase=Run%20this%20report" target="_blank">PayPal payments for a date range you specify</a></p>
      <p>------</p>
      <p>The formula that determines which library receives the payment is based on:</p>
      <ul>
        <li>Automaticly generated late fees are paid to the library where the item was checked out</li>
        <li>Automatically generated lost item fees are paid to the library that owns the item</li>
        <li>Manually created lost item fees are paid to the library that owns the item if a barcode number is linked to the fee</li>
        <li>Manually created non-lost-item fees are paid to the library that created the fee if it can be determined by the managerid field in the accountlines table</li>
        <li>Any manually created fees where the creating library cannot be determined will be paid to the patron's home library</li>
      </ul>
    </div>
  </div>
  <!-- TABR06 NEW TAB -->
  <div class="mptabContent" id="tabR06">
    <h2>Contact information</h2>
    <div>
      <p>Content coming soon</p>
    </div>
  </div>
  <!-- END -->
</body>


























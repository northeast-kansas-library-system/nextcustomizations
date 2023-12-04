SP.IntranetCirculationHomeHTML.txt

----------

Preference name: IntranetCirculationHomeHTML

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

  div.mptabContent.hide {
    display: none;
  }

  div.mptabContent {
    padding: 2% 2% 2% 2%
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
  <br />
  <h1>Next Search Catalog</h1>
  <ul id="mptabs">
    <li><a href="#tabC01">Library contact information</a></li>
    <li><a href="#tabC02">Holds Queue Schedule</a></li>
    <li><a href="#tabC03" style="display:none;">Tab 3</a></li>
    <li><a href="#tabC04" style="display:none;">Tab 4</a></li>
    <li><a href="#tabC05" style="display:none;">Tab 5</a></li>
  </ul>

  <div class="mptabContent" id="tabC01">
    <h2>Library contact information</h2>
    <div>
      <h3>If your contact information is incorrect, please send an e-mail to <a href="mailto:nexthelp@nekls.org">nexthelp@nekls.org</a> and tell us which library you're at, what information is incorrect, and what the correct information is.</h3>

      <div id="libtable" class="dataTables_wrapper">

        
        
        <span style="padding: 10px"><input id="myInput" type="text" placeholder="Search.." style="padding: 10px"><a href="#" class="clear" rel="nofollow"><span style="padding: 10px">Clear</span></a></span>
        
        <table id="library_table" class="table table-hover table-bordered filtertable">
          
       
          <thead>
            <tr>
              <th>Library</th>
              <th>Contact information</th>
              <th>Staff contacts / report link</th>
              <th>Logo/photo</th>
            </tr>
          </thead>
          <tfoot>
            <td style="text-align: center; font-weight: 700; background-color: #e8e8e8;">Library</td>
            <td style="text-align: center; font-weight: 700; background-color: #e8e8e8;">Contact information</td>
            <td style="text-align: center; font-weight: 700; background-color: #e8e8e8;">Staff contacts / holdings</td>
            <td style="text-align: center; font-weight: 700; background-color: #e8e8e8;">Logo/photo</td>
          </tfoot>  
          <tbody>
          </tbody>
        </table>
      </div>
      
    </div>
  </div>


  <div class="mptabContent" id="tabC02">
    <h2>Holds Queue Schedule</h2>
    <div>
      <h3><span style="background-color: yellow;">The holds queue was last rebuilt 
      <script>
         var lr = new Date();
         lr.setMinutes( lr.getMinutes() +8 );
         document.write( lr.getMinutes() );
      </script>
       minutes ago</span></h3>
      <h4>The holds queue is rebuilt every hour at 52 minutes past the hour, 24 hours per day.</h4>
      <p><a href="/cgi-bin/koha/reports/guided_reports.pl?reports=2778&phase=Run%20this%20report">Click here to run the holds queue report for your library.</a></p>

    </div>
  </div>
  <div class="mptabContent" id="tabC03">
    <h2>Reports</h2>
    <div>
      <h3>Title</h3>
      <p>Content coming soon</p>
      

      
    </div>
  </div>
  <div class="mptabContent" id="tabC04">
    <h2>Tab 4</h2>
    <div>
      <h3>Title</h3>
      


    </div>
  </div>
  <div class="mptabContent" id="tabC05">
    <h2>Contact information</h2>
    <div>
      <p>Content coming soon</p>
    </div>
  </div>
</body>


























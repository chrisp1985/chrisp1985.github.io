        /**
         * *** WAIT FOR AN OBJECT ***
         * This waits for an object to appear in the application by constantly polling the available objects.
         *
         * @param winRoot
         *      The AutomationElement from which to start the search. If it's left blank, it'll query objects from the very top level.
         *
         * @param node
         *      A blank treenode to fill out the childTreeNode stuff.
         *
         * @param timeToWait
         *      The time to wait for the object to appear. If the timer exceeds this time, the method will fail.
         *
         * @param elementName
         *      The name of the element by the Page Objects method. Eg, to find the completion of the progress bar, this is 'progressBarComplete'.
         *
         * @param args
         *      The arguments required by the element as in the Page Objects.
         *
         * @return
         *      Returns the found object.
         */
        public AutomationElement waitForObject(AutomationElement winRoot, TreeNode node, double timeToWait, String elementName, object[] args)
        {
            // Set the time.
            DateTime timeAtStart = DateTime.Now;
            DateTime now = new DateTime(1985, 10, 26, 13, 15, 00); // Back to the Future Day - Oct 26th 1985.

            // Set the returned element to be null (so if the element isn't found, null is returned).
            AutomationElement returnedEle = null;

            // While the timer hasn't expired...
            while (now.Subtract(timeAtStart).TotalSeconds < timeToWait)
            {
                try
                {
                    // Create the object here.
                    MethodInfo method = typeof(ArcGIS_PageObjects).GetMethod(elementName);
                    AutomationElement root = null;
                    if (winRoot == null)
                    {
                        root = AutomationElement.RootElement.FindChildByProcessId(ArcGIS_AutomationMethods.processId);
                    }
                    else
                    {
                        root = winRoot;
                    }

                    // Invoke the element through reflection.
                    AutomationElement newEle = (AutomationElement)method.Invoke(new ArcGIS_PageObjects(), args);
                    if (newEle.GetCurrentPropertyValue(AutomationElement.IsEnabledProperty).Equals(true))
                    {
                        // OMG, you found the element.
                        returnedEle = newEle;
                        break;
                    }
                }
                catch
                {
                    // Just carry on.
                }
                // Reset the time.
                now = DateTime.Now;
            }

            // Has the timer expired?
            if (now.Subtract(timeAtStart).TotalSeconds > timeToWait)
            {
                Assert.Fail("Wait time was exceeded for element so test failed.");
            }

            // Return the element.
            return returnedEle;
        }
